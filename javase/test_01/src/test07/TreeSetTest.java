package test07;

import java.util.TreeSet;

public class TreeSetTest {
	public static void  main(String[] args) {
		TreeSet numsSet = new TreeSet();
		numsSet.add(5);
		numsSet.add(2);
		numsSet.add(10);
		numsSet.add(-9);
		System.out.println(numsSet);
		System.out.println(numsSet.first());
		System.out.println(numsSet.last());
		System.out.println(numsSet.headSet(4));
		System.out.println(numsSet.tailSet(5));
		System.out.println(numsSet.subSet(-3, 4));
	}
}
