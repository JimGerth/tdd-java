
public class Money {
	
	protected int amount;
	protected String currency;
	
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	/* factory methods for different currencies */
	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	/* helper functions to supply functionality like comparison and multiplication */
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && currency() == money.currency();
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	/* getter for private field currency */
	String currency() {
		return currency;
	}

}
