package A07_BubbleSort;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {

		Person[] array = new Person[personen.length];
		
		
		boolean change = true;
		
		while(change){
			
			for (int i = 0; i < array.length-1; i++) {
				Person p = array[i];
				
				int test = array[i].compareTo(p);
				if(test==-1){
					
				}
			}
			
		}
	}
	
}
