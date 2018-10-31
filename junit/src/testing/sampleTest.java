package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class sampleTest {

	Arithmetic am=new Arithmetic();
	@Test
	public void test() {
		assertEquals(7, am.add(3, 4));
	}
	@Test
	public void failCase() {
		assertNotEquals(8, am.add(10, 20));
	}

}
