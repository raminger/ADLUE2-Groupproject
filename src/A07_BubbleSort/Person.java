package A07_BubbleSort;

public class Person {
	
	private final String nachname;
	
	private final String vorname;

	public Person(String vorname, String nachname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Vergleicht zwei Personen miteinander
	 * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
	 */
	public int compareTo(Person p) {
			
		int bla = stringCompare(this.nachname, p.getNachname());
		
		if (bla == 0)
			bla = stringCompare(this.vorname, p.getVorname());
		
		return bla;
	}
	
	private int stringCompare(String a, String b)
	{
		for (int i = 0; i < a.length(); i++) {
			char value1 = a.charAt(i);
			char value2 = b.charAt(i);
			
			if (value1 > value2)
				return 1;
			else if (value1 < value2)
				return -1;
		}
		
		return 0;
	}
}
