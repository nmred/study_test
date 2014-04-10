package test07;

import java.util.ArrayList;
import java.util.List;

class A1 {
	public boolean equals(Object obj) {
		return true;
	}
}
public class ListTest2 {
	public static void main(String[] args) {
		List booksList = new ArrayList();
		booksList.add(new String("轻量级Java EE企业应用实战"));
		booksList.add(new String("疯狂Java讲义"));
		booksList.add(new String("疯狂Android讲义"));
		System.out.println(booksList);
		booksList.remove(new A1());
		booksList.remove(new A1());
		System.out.println(booksList);
	}
}
