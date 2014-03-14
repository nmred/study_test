package test07;

import java.util.HashSet;

class A {
	public boolean equals(Object obj) {
		return true;
	}
}

class B extends Object{
	private String name = new String("dsds");
	public int hashCode() {
		return 12;
	}
}
class C {
	public boolean equals(Object obj) {
		return true;
	}
	
	public int hashCode() {
		return 2;
	}
}
public class HashSetTest {
	public static void main(String[] args) {
		HashSet booksHashSet = new HashSet();
		booksHashSet.add(new A());
		booksHashSet.add(new A());
		booksHashSet.add(new B());
		booksHashSet.add(new B());
		booksHashSet.add(new C());
		booksHashSet.add(new C());
	
		System.out.println(booksHashSet);
	}
}

