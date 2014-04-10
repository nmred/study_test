package test07;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("语文", 80);
		scores.put("语文", 82);
		scores.put("数学", 76);
		
		for (Object keyObject : scores.keySet()) {
			System.out.println(keyObject + "------>" + scores.get(keyObject));
		}
	}
}
