package A01_Stack;


public class Stack<T> {
	private Node<T> first;
	private int count = 0;

	/**
	 * Oberstes Element entfernen und zur�ckliefern.
	 * Existiert kein Element, wird eine Exception ausgel�st.
	 *
	 * @throws StackEmptyException
	 */
	public T pop() throws StackEmptyException {

		if (first == null) {
			throw new StackEmptyException();
		}
		Node<T> help = first;
		first = first.getNext();
		count--;
		return (T) help.getData();
	}

	/**
	 * �bergebenen T auf Stack (als oberstes Element) speichern.
	 *
	 * @param i data
	 */
	public void push(T i) {
		Node<T> help = new Node(i);
		if (first == null) {
			first = help;

		} else {
			help.setNext(first);
			first = help;
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