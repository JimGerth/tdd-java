
public class Sum implements Expression {
	
	private Expression augend;
	private Expression addend;
	
	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money reduce(Bank bank, String currency) {
		return new Money(bank.reduce(augend, currency).amount + bank.reduce(addend, currency).amount, currency);
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}
	
	public boolean equals(Object object) {
		Expression expression = (Expression) object;
		return new Bank().reduce(expression, "USD").equals(new Bank().reduce(this, "USD"));
	}

}
