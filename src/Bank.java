import java.util.Hashtable;

public class Bank {
	
	private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();

	public Money reduce(Expression expression, String currency) {
		return expression.reduce(this, currency);
	}

	@SuppressWarnings("deprecation")
	public void addRate(String currency1, String currency2, int rate) {
		rates.put(new Pair(currency1, currency2), new Integer(rate));
	}
	
	int rate(String from, String to) {
		return from == to ? 1 : ((Integer) rates.get(new Pair(from, to))).intValue();
	}

}
