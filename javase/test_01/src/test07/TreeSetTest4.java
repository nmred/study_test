package test07;

import java.util.Comparator;
import java.util.TreeSet;

class M {
	int age;
	public M(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "M[age:" + age + "]";
	}
}
public class TreeSetTest4 {
	public static void main(String[] args) {
		TreeSet tSet = new TreeSet(new Comparator() {
			public int compare(Object obj1, Object obj2) {
				M m1 = (M)obj1;
				M m2 = (M)obj2;
				return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
			}
		});
		
		tSet.add(new M(5));
		tSet.add(new M(-4));
		tSet.add(new M(9));
		System.out.println(tSet);
	}
}
