package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitAssertion {

	String obj1="medplus";
	String obj2="medplus";
	String obj5=null;
	int var1=15;
	int var2=25;
	int[] arithmetic1= {10,20,30};
	int[] arithmetic2= {10,20,30};
	@Test
	public void testEquals() {
		assertEquals("they are not equal", obj1,obj2);
		assertNull(obj1);
	}
	@Test
	public void testNull() {
		assertNull(obj5);
	}
	@Test
	public void test() {
		assertTrue(var1<var2);
	}
	@Test
	public void testArray() {
		assertArrayEquals(arithmetic1,arithmetic2);
	}
}
