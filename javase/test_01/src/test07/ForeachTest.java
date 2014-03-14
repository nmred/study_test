package test07;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args) {
		Collection booksCollection = new HashSet();
		booksCollection.add(new String("轻量级Java EE 企业应用实战"));
		booksCollection.add(new String("疯狂Java讲义"));
		booksCollection.add(new String("疯狂Android讲义"));
		for(Object book : booksCollection) {
			System.out.println(book);
		}
	}
}
