
public class Sum implements Expression {
	
	private Money augend;
	private Money addend;
	
	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money reduce(String currency) {
		return new Money(augend.amount + addend.amount, currency);
	}

}
