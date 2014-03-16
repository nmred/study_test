package test07;

import java.util.TreeMap;

class RA implements Comparable {
	int count;
	public RA(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "R[count:" + count + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == RA.class) {
			RA ra = (RA)obj;
			return this.count == ra.count;
		}
		
		return false;
	}
	
	public int compareTo(Object obj) {
		RA r = (RA)obj;
		return count > r.count ? 1 : count < r.count ? -1 : 0;
	}
}
public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap tm = new TreeMap();
		tm.put(new RA(3), "轻量级Java EE企业应用实战");
		tm.put(new RA(-5), "疯狂Java讲义");
		tm.put(new RA(9), "疯狂Android 讲义");
		System.out.println(tm);
		System.out.println(tm.firstEntry());
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new RA(2)));
		System.out.println(tm.lowerEntry(new RA(2)));
		System.out.println(tm.subMap(new RA(-1), new RA(4)));
		
	}
}
