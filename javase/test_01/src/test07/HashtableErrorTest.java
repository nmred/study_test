package test07;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableErrorTest {
	public static void main(String[] args) {
		Hashtable htHashtable = new Hashtable();
		htHashtable.put(new A2(2), "疯狂Java讲义");
		htHashtable.put(new A2(4), "轻量级Java EE企业应用实战");
		Iterator it = htHashtable.keySet().iterator();
		A2 first = (A2)it.next();
		first.count = 2;
		System.out.println(htHashtable);
		htHashtable.remove(new A2(2));
		System.out.println(htHashtable);
		System.out.println(htHashtable.get(new A2(2)));
		System.out.println(htHashtable.get(new A2(4)));
	}
}
