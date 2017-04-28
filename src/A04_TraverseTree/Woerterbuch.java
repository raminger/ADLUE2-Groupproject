package A04_TraverseTree;

import java.util.HashSet;
import java.util.Set;


public class Woerterbuch {
	

	/**
	 * Wurzel des Baums (Startknoten)
	 */
	private Wort root;
	private int count=1;
	private Set<String> setprefix = new HashSet<>();
	
	public Wort getRoot() {
		return root;
	}

	/**
	 * Zaehlt alle Woerter des Teilbaums ab einem bestimmten Wort
	 * @param w Wort
	 * @return Zahl der Woerter (=Anzahl der Elemente)
	 */
	public int countWordsInSubTree(Wort w) {
		if(w==null){
			return 0;
		}
		if (w.getLeft()!=null){
			count++;
			countWordsInSubTree(w.getLeft());
		}
		if(w.getRight()!=null){
			count++;
			countWordsInSubTree(w.getRight());
		}
		return count;
	}

	/**
	 * Liefert die Menge aller Woerter retour, die ein spezifisches Praefix haben.
	 * @param prefix Woerter muessen diesen Praefix haben
	 * @return Menge aller zutreffenden Woerter
	 */
	public Set<String> getWordsWithPrefix(String prefix) {
		getWordsWithPrefix(prefix, root);
		return setprefix;
	}
	
	public void getWordsWithPrefix(String prefix,Wort w){	//Ina: Glaube wir haben zuerst unser prefix aufgerufen, und das Wort damit vergleichen, statt Wort aufrufen und das mitn Prefix vergleichen
		if(w.getWort().startsWith(prefix)){					//bitte um Kontrolle, Idee von Ina! laut JUnit is alles grün!
			setprefix.add(w.getWort());
		}
		if (w.getLeft()!=null){
			getWordsWithPrefix(prefix,w.getLeft());
		}
		if(w.getRight()!=null){
			
			getWordsWithPrefix(prefix,w.getRight());
		}
		
	}

	/**
	 * Neues Wort hinzufuegen
	 * @param wort Hinzuzufuegendes Wort
	 */
	public void add(String wort) {
		Wort neu = new Wort(wort);
		if (root == null) {			// Fall 1: Baum ist leer
			root = neu;
			return;
		}
		Wort w = root;				// Fall 2: Baum ist nicht leer
		while (true) {
			int vgl = wort.compareTo(w.getWort());
			if (vgl < 0) {			// Neues Wort ist lexikographisch kleiner
				if (w.getLeft() == null) {
					w.setLeft(neu);
					neu.setParent(w);
					return;
				}
				w = w.getLeft();
			}
			else if (vgl > 0) {		// Neues Wort ist lexikographisch groeï¿½er
				if (w.getRight() == null) {
					w.setRight(neu);
					neu.setParent(w);
					return;
				}
				w = w.getRight();
			}
			else {					// Neues Wort ist lexikographisch gleich
				return;
			}
		}
	}

	public Wort find(String s) {
		return find(root, s);
	}
	
	private Wort find(Wort current, String s) {
		if (current == null) {
			return null;
		}
		int vgl = s.compareTo(current.getWort());
		if (vgl == 0) {		// Gefunden
			return current;
		}
		else if (vgl < 0) {	// Links
			return find(current.getLeft(), s);
		}
		else {				// Rechts
			return find(current.getRight(), s);
		}
	}
	
}
