package laboration2;

import java.util.Comparator;

public class FamilyNameFirstName implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		String n1 = o1.getFirstName(), n2 = o1.getFirstName();
		int compare = n1.compareTo(n2);
		return compare;
	}

}
