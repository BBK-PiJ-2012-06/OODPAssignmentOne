package assignments.ass1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	private List<Object> objList;
	private List<Integer> intList;
	private Object[] objects;
	private Integer[] ints;
	
	@Before
	public void setUp() throws Exception {
		objList = new List<Object>();
		intList = new List<Integer>();
		objects = new Object[11];
		ints = new Integer[10];
		for(int i=0; i<10; i++) {
			ints[i] = new Integer(i+1);
		}
	}

	@Test
	public void testAddToEnd() {
		for(int i=0; i<10; i++) {
			objList.addToEnd(objects[i]);
		}
	}
	
	@Test
	public void testAddToEndWhenFull() {
		for(Object object : objects) {
			objList.addToEnd(object);
		}
	}

	@Test
	public void testToString() {
		assertEquals("[]", intList.toString());
		for(Integer i : ints) {
			intList.addToEnd(i);
		}
		String expected = "[1 2 3 4 5 6 7 8 9 10]";
		assertEquals(expected, intList.toString());
	}
}
