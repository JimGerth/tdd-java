
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

}
