package laboration3;

import java.util.Comparator;

public class LastnameAsc implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		String 	name1 = p1.getLastname(),
				name2 = p2.getLastname();
		return name1.compareTo(name2);
	}

}
