package A07_BubbleSort;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		Person[] array = personen;
		Person p ;		
		
		boolean change = true;
		
		while(change){
			change = false;
			
			for (int i = 0; i < array.length-1; i++) {
				if (array[i].compareTo(array[i + 1]) == 1) {
					p = array[i];
					array[i] = array[i + 1];
					array[i + 1] = p;
					change = true;					
				}				
			}			
		}
		
		personen = array;
	}
	
}
