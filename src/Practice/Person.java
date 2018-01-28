package Practice;

class Person implements Comparable<Person>{
	int id;
	String name;
	int age;
	
	public Person(int id, String name, int age){
		this.id = id;
		this.name=name;
		this.age=age;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString(){
		return name;
	}
}
