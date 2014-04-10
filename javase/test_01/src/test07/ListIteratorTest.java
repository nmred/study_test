package test07;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	public static void main(String[] args) {
		String[] booksStrings = {
				"疯狂Java讲义",
				"轻量级Java EE企业应用实战"
		};
		
		List booList = new ArrayList();
		for (int i = 0, len = booksStrings.length; i < len; i++) {
			booList.add(booksStrings[i]);
		}
		
		ListIterator lit = booList.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
			lit.add("---------分割线----------");
		}
		System.out.println("下面是反向迭代");
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
}
