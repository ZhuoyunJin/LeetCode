package Practice;

import java.util.PriorityQueue;

public class PQueue {
	public static void main(String[] args) {
		Person p1 = new Person(1, "John", 13);
		Person p2 = new Person(2, "Ada", 20);
		Person p3 = new Person(3, "Peter", 8);
		PriorityQueue<Person> pQueue = new PriorityQueue<Person>();
		pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		System.out.println(pQueue);
	}
}
