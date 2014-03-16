package test07;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap whmHashMap = new WeakHashMap();
		whmHashMap.put(new String("语文"), new String("良好"));
		whmHashMap.put(new String("数学"), new String("及格"));
		whmHashMap.put(new String("英文"), new String("中等"));
		
		whmHashMap.put("java", new String("中等"));
		
		System.out.println(whmHashMap);
		System.gc();
		System.runFinalization();
		System.out.println(whmHashMap);
	}
}
