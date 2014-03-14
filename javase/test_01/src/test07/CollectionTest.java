package test07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("孙悟空");
		c.add(6);
		System.out.println("c集合的元素个数为：" + c.size());
		c.remove(6);
		System.out.println("c集合的元素个数为：" + c.size());
		System.out.println("c集合是否包含\"孙悟空\"字符串：" + c.contains("孙悟空"));
		c.add("轻量级 Java EE企业应用实战");
		System.out.println("c集合的元素：" + c);
		Collection books = new HashSet();
		books.add("轻量级 Java EE 企业应用实战");
		books.add("疯狂 Java 讲义");
		System.out.println("c集合是否完全包含books集合？" + c.containsAll(c));
		c.removeAll(books);
		System.out.println("c集合的元素：" + c);
		c.clear();
		System.out.println("c集合的元素：" + c);
		books.retainAll(c);
		System.out.println("books 集合的元素：" + books);
	}
}
