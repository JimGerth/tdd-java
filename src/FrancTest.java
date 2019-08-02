import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FrancTest {

	@Test
	public void testMultiplication() {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertFalse(Money.franc(5).equals(Money.franc(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	@Test
	public void testCurrency() {
		assertEquals("CHF", Money.franc(1).currency());
	}
	
	@Test
	public void testSimpleAddition() {
		assertEquals(new Bank().reduce(Money.franc(1), "CHF"), Money.franc(1));
		assertEquals(new Bank().reduce((Sum) Money.franc(5).plus(Money.franc(5)), "CHF"), Money.franc(10));
		assertEquals(new Bank().reduce((Sum) Money.franc(10).plus(Money.franc(10)), "CHF"), Money.franc(20));
	}
	
	@Test
	public void testMixedAddition() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		assertEquals(bank.reduce(Money.dollar(5).plus(Money.franc(10)), "USD"), Money.dollar(10));
	}
	
	@Test
	public void testMultipleAddition() {
		assertEquals(new Bank().reduce(Money.franc(5).plus(Money.franc(10)).plus(Money.franc(15)), "CHF"), Money.franc(30));
	}
	
	@Test
	public void testCurrencyConversion() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		assertEquals(bank.reduce(Money.franc(2), "USD"), Money.dollar(1));
	}
	
	@Test
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("CHF", "CHF"));
	}

}
