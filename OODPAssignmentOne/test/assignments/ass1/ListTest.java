package assignments.ass1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	private List<String> strList;
	private List<Integer> intList;
	private String[] strings;
	private Integer[] ints;
	
	@Before
	public void setUp() throws Exception {
		strList = new List<>();
		intList = new List<>();
		strings = new String[11];
		for (int i = 0; i < 11; i++) {
			strings[i] = ".";
		}
		ints = new Integer[10];
		for(int i=0; i<10; i++) {
			ints[i] = new Integer(i+1);
		}
	}

	@Test
	public void testAddToEnd() {
		for(int i=0; i<10; i++) {
			strList.addToEnd(strings[i]);
		}
		for(int i=0; i<10; i++) {
			assertEquals(strings[i], strList.nextElement());
		}
	}
	
	@Test
	public void testAddToEndWhenFull() {
		for(String str : strings) {
			strList.addToEnd(str);
		}
		for(String str : strings) {
			assertEquals(str, strList.nextElement());
		}
	}
	
	@Test
	public void testAddNullToEnd() {
		intList.addToEnd(6);
		intList.addToEnd(null);
		intList.addToEnd(7);
		// Desired behaviour of addToEnd() is to ignore the null call
		String expected = "[6 7]";
		assertEquals(expected, intList.toString());
	}

	@Test
	public void testToString() {
		for(Integer i : ints) {
			intList.addToEnd(i);
		}
		String expected = "[1 2 3 4 5 6 7 8 9 10]";
		assertEquals(expected, intList.toString());
	}
	
	@Test
	public void testToStringWhenEmpty() {
		assertEquals("[]", intList.toString());
	}
	
	@Test
	public void testFirstElement() {
		for(Integer i : ints) {
			intList.addToEnd(i);
		}
		intList.firstElement();
		intList.nextElement();
		intList.nextElement();
		intList.firstElement();
		
		assertEquals(ints[0], intList.nextElement());
	}
	
	@Test
	public void testNextElement() {
		for(Integer i : ints) {
			intList.addToEnd(i);
		}
		for(Integer i : ints) {
			assertEquals(i, intList.nextElement());
		}
	}
	
	@Test
	public void testHasMoreElements() {
		assertFalse(intList.hasMoreElements());
		
		intList.addToEnd(ints[0]);
		intList.addToEnd(ints[1]);
		assertTrue(intList.hasMoreElements());
		
		intList.nextElement();
		intList.nextElement();
		assertFalse(intList.hasMoreElements());
	}
}
