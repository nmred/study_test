package test07;

import java.util.HashSet;
import java.util.Iterator;

class R {
	int count;
	public R (int count) {
		this.count = count;
	}
	
	public String toString() {
		return "R[count:" + count + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj != null && obj.getClass() == R.class) {
			R r = (R)obj;
			if (r.count == this.count) {
				return true;
			}
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.count;
	}
}
public class HashSetTest2 {
	public static void main(String[] args) {
		HashSet hsHashSet = new HashSet();
		hsHashSet.add(new R(5));
		hsHashSet.add(new R(-3));
		hsHashSet.add(new R(9));
		hsHashSet.add(new R(-2));
		
		System.out.println(hsHashSet);
		Iterator it = hsHashSet.iterator();
		R firstR = (R)it.next();
		firstR.count = -3;
		System.out.println(hsHashSet);
		hsHashSet.remove(new R(-3));
		System.out.println(hsHashSet);
		System.out.println("hs 是否包含count 为 -3 的 R 对象?" + hsHashSet.contains(new R(-3)));
		System.out.println("hs 是否包含count 为 5 的 R 对象?" + hsHashSet.contains(new R(5)));
	}
}
