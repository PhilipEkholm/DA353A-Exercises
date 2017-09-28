package laboration2;

import java.util.Comparator;

public class FamilyName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		String n1 = o1.getFamilyName(), n2 = o1.getFamilyName();
		int compare = n1.compareTo(n2);
		
		return compare;
	}

}
