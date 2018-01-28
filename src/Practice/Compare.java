package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Compare {

	public static void main(String[] args) {
		Person p1 = new Person(1, "John", 13);
		Person p2 = new Person(2, "Ada", 20);
		Person p3 = new Person(3, "Peter", 8);
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}
