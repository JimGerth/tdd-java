
public class Bank {

	public Money reduce(Expression expression, String currency) {
		return expression.reduce(currency);
	}

}
