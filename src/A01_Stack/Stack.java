package A01_Stack;


public class Stack<T> {
	private Node<T> first;
	private int count = 0;

	/**
	 * Oberstes Element entfernen und zurückliefern.
	 * Existiert kein Element, wird eine Exception ausgelöst.
	 *
	 * @throws StackEmptyException
	 */
	public T pop() throws StackEmptyException {

		if (first == null) {
			throw new StackEmptyException();
		}

		Node<T> tmp = first;

		if (count > 1)
		{
			first = first.getNext();
		} else {
			first = null;
		}

		count--;

		return (T) tmp.getData();
	}

	/**
	 * Übergebenen T auf Stack (als oberstes Element) speichern.
	 *
	 * @param i data
	 */
	public void push(T i) {
		Node<T> tmp = new Node(i);
		if (first == null) {
			first = tmp;
		} else {
			tmp.setNext(first);
			first = tmp;
		}

		count++;
	}

	/**
	 * Liefert die Anzahl der Elemente im Stack
	 *
	 * @return
	 */
	public int getCount() {
		return count;
	}
}