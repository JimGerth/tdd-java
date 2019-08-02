import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DollarTest {

	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}
	
	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
	}
	
	@Test
	public void testSimpleAddition() {
		assertEquals(new Bank().reduce(Money.dollar(1), "USD"), Money.dollar(1));
		assertEquals(new Bank().reduce((Sum) Money.dollar(5).plus(Money.dollar(5)), "USD"), Money.dollar(10));
		assertEquals(new Bank().reduce((Sum) Money.dollar(10).plus(Money.dollar(10)), "USD"), Money.dollar(20));
	}
	
	@Test
	public void testMixedAddition() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		assertEquals(bank.reduce(Money.dollar(5).plus(Money.franc(10)), "USD"), Money.dollar(10));
	}
	
	@Test
	public void testMultipleAddition() {
		assertEquals(new Bank().reduce(Money.dollar(5).plus(Money.dollar(10)).plus(Money.dollar(15)), "USD"), Money.dollar(30));
	}
	
	@Test
	public void testSumTimes() {
		Bank bank = new Bank();
		bank.addRate("CHF",  "USD", 2);
		assertEquals(bank.reduce(Money.dollar(5).plus(Money.franc(10)).times(2), "USD"), Money.dollar(20));
	}
	
	@Test
	public void testCurrencyConversion() {
		Bank bank = new Bank();
		bank.addRate("USD", "CHF", 2);
		assertEquals(bank.reduce(Money.dollar(2), "CHF"), Money.franc(1));
	}
	
	@Test
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}

}
