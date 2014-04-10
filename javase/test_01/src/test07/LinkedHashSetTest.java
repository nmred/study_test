package test07;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet booksHashSet = new LinkedHashSet();
		booksHashSet.add("疯狂Java讲义");
		booksHashSet.add("轻量级Java EE企业应用实战");
		System.out.println(booksHashSet);
		booksHashSet.remove("疯狂Java讲义");
		booksHashSet.add("疯狂Java讲义");
		System.out.println(booksHashSet);
	}
}
