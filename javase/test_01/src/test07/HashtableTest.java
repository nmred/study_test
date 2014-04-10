package test07;

import java.util.Hashtable;

import javax.swing.text.html.HTML;

class A2 {
	int count;
	public A2 (int count) {
		this.count = count;
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj != null && obj.getClass() == A2.class) {
			A2 a = (A2)obj;
			return this.count == a.count;
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.count;
	}
}

class B1 {
	public boolean equals(Object obj) {
		return true;
	}
}
public class HashtableTest {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new A2(60000), "疯狂Java讲义");
		ht.put(new A2(9), "轻量级Java EE企业应用实战");
		ht.put(new A2(10), new B1());
		System.out.println(ht);
		
		System.out.println(ht.containsValue("测试字符串"));
		System.out.println(ht.containsKey(new A2(9)));
		
		ht.remove(new A2(10)); // 删除最后一个元素
		
		for (Object keyObject : ht.keySet()) {
			System.out.println(keyObject + "----->");
			System.out.println(ht.get(keyObject) + "\n");
		}
	}
}