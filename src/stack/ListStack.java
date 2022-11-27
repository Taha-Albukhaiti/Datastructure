package stack;

/**
 * Ueberschrift: Implementierung der Stapel-Schnittstelle als verkettete Liste.
 * Beschreibung: Der Stapel wird als verkettete Liste, unter der Verwendung von
 * ListNode-Objekten und einem Zeiger (head), der immer auf das oberste Element
 * des Stapels zeigt, implementiert. Copyright: Copyright (c) 2002 Organisation:
 * BHT-Berlin (Projektgruppe VFH)
 * 
 * @author A. Merceron - Umstellung auf generic
 * @version 1.1
 */
public class ListStack<E> implements Stack<E> {

	// Instanzvariablen
	private ListNode<E> head; // zeigt immer auf das oberste Element

	// Konstruktor

	/**
	 * erzeugt ein leeres ListStack-Objekt
	 */
	public ListStack() {
		head = null;
	}

	// Methoden

	/**
	 * Ueberprueft, ob der Stapel leer ist.
	 * 
	 * @return boolean true falls der Stapel leer ist, false sonst
	 */
	public boolean empty() {
		return (head == null);
	}

	/**
	 * Ueberprueft, ob der Stapel voll ist.
	 * 
	 * @return false Der Stapel als verkettete Liste kann nie voll werden.
	 */
	public boolean full() {
		return false; // Standard-Rueckgabewert
	}

	/**
	 * Ein neu erzeugtes ListNode-Objekt wird dem Stapels als oberstes Element
	 * hinzugefuegt.
	 * 
	 * @param e
	 *            zu speicherndes Element
	 */
	public void push(E e) {
		// Das uebergebene Object 'e' und die Referenz auf das
		// vorherige oberste Element des Stapels werden in dem
		// ListNodeGen-Objekt
		// gespeichert (Verkettung).
		// Durch die Zuweisung in head ist das neue Objekt oben
		head = new ListNode<>(e, head);
	}

	/**
	 * Falls der Stapel nicht leer ist, wird das oberste Element des Stapels
	 * entfernt und als Ergebnis zurueckgegeben, andernfalls wird ein
	 * EmptyStackException-Objekt geworfen.
	 * 
	 * @return entferntes Element
	 * @throws EmptyStackException
	 */
	public E pop() throws EmptyStackException {
		if (!empty()) {
			E e = head.element;
			head = head.next;
			return e;
		} else {
			throw new EmptyStackException("Der Stapel ist leer !!!");
		}
	}

	/**
	 * Gibt die Stapel-Elemente, beginnend mit dem Obersten, und zwischen "[]"
	 * als String zurueck. Die Elemente werden mit ',' getrennt. Wenn der Stapel
	 * leer ist, wird einfach "[]" zurueckgegeben.
	 * 
	 * @return String Stapels als Zeichenkette
	 */
	@Override
	public String toString() {
		if (!empty()) {
			StringBuilder returnVal = new StringBuilder("[");
			ListNode<E> temp = head;
			while (temp.next != null) {
				returnVal.append(temp.element.toString() + ", ");
				temp = temp.next;
			}
			returnVal.append(temp.element.toString() + "]");
			return returnVal.toString();
		} else {
			return "[]";
		}
	}

	/**
	 * Innere Klasse ListNode.
	 */
	private static class ListNode<T> {

		// Instanzvariablen
		private T element; // gespeichertes Listenelement
		private ListNode<T> next; // Verweis auf Nachfolger-Listenelement

		// Konstruktoren

		private ListNode(T e, ListNode<T> n) {
			element = e; // Referenz auf das zu speichernde Element
			next = n; // Referenz auf das Nachfolger-Listenelement
		}

		private ListNode(T e) {
			this(e, null);
		}

		private ListNode() {
			this(null, null);
		}
	} // end Listnode

}
