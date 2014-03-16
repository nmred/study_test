package test07;

import java.util.HashMap;

public class NullInHashMap {
	public static void main(String[] args) {
		HashMap hm1 = new HashMap();
		hm1.put(null, null);
		hm1.put(null, null);
		hm1.put("a", null);
		System.out.println(hm1);
	}
}
