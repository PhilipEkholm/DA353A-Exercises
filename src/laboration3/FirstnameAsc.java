package laboration3;

import java.util.Comparator;

public class FirstnameAsc implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		
		String 	n1 = p1.getFirstname(),
				n2 = p2.getFirstname();
		
		return n1.compareTo(n2);
	}

}
