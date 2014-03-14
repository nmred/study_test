package test07;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set books = new HashSet();
		books.add(new String("疯狂Java讲义"));
		boolean result = books.add(new String("疯狂Java讲义"));
		System.out.println(result + "-->" + books);
	}
}
