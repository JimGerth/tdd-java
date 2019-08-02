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
		assertTrue(new Money(10, "USD").equals(new Franc(10, "USD")));
		assertTrue(new Money(10, "USD").equals(Money.dollar(10)));
	}

}
