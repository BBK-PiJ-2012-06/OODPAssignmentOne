package assignments.ass1;

/*
 * List class
 *
 * A List is an ordered collection of any kind of object specified in the parameter.
 *
 * Operations:
 * addToEnd Add a given object to the end of the list.
 * toString A String form of the objects in the list in order,
 * enclosed in square brackets, separated by spaces.
 */
public class List<T> {
	private static final int INIT_LEN = 10;
	private T[] items; // the actual items
	private int numItems; // the number of items currently in the list
	
	/*
	 * constructor: initialize the list to be empty
	 */
	@SuppressWarnings("unchecked")
	public List() {
		items = (T[]) new Object[INIT_LEN];
		numItems = 0;
	}
	
	/*
	 * AddToEnd
	 *
	 * Given: Object obj Do: Add obj to the end of the list.
	 * If obj is null do nothing.
	 */
	public void addToEnd(T obj) {
		// Check obj is not null
		if(obj == null) {
			return;
		}
		// Check if items is full
		if(numItems == items.length) {
			doubleArrayLength();
		}
		items[numItems++] = obj;
	}
	
	/*
	 * toString
	 *
	 * A String form of the objects in the list in order, enclosed in
	 * square brackets, separated by spaces.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append('[');
		if(numItems > 0) {
			result.append(items[0].toString());
			// We want number of spaces to be equal to numItems - 1
			for(int i=1; i<numItems; i++) {
				result.append(' ');
				result.append(items[i].toString());
			}
		}
		result.append(']');
		return result.toString();
	}
	
	@SuppressWarnings("unchecked")
	private void doubleArrayLength() {
		T[] temp = (T[]) new Object[2 * numItems];
		for(int i=0; i<numItems; i++) {
			temp[i] = items[i];
		}
		items = temp;		
	}
}