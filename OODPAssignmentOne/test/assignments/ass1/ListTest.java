package assignments.ass1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	private List<Object> list;
	private Object[] objects;
	
	@Before
	public void setUp() throws Exception {
		list = new List<Object>();
		objects = new Object[11];
		for(Object object : objects) {
			object = new Object();
		}
	}

	@Test
	public void testAddToEnd() {
		for(int i=0; i<10; i++) {
			list.addToEnd(objects[i]);
		}
	}
	
	@Test
	public void testAddToEndWhenFull() {
		for(Object object : objects) {
			list.addToEnd(object);
		}
	}

}
