package test07;

import java.util.TreeSet;

class R1 implements Comparable {
	int count;
	public R1(int count) {
		this.count = count;
	}
	
	public String toString()
	{
		return "R[count:" + count + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj != null && obj.getClass() == R1.class) {
			R1 r = (R1)obj;
			if (r.count == this.count) {
				return true;
			}
		}
		
		return false;
	}
	
	public int compareTo(Object obj) {
		R1 r = (R1)obj;
		return count > r.count ? 1 : count < r.count ? -1 : 0;
	}
}
public class TreeSetTest3 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new R1(5));
		ts.add(new R1(-3));
		ts.add(new R1(9));
		ts.add(new R1(-2));
		System.out.println(ts);
		
		R1 firstR1 =(R1)ts.first();
		firstR1.count = 20;
		
		R1 lastR1 = (R1)ts.last();
		lastR1.count = -2;
		
		System.out.println(ts);
		System.out.println(ts.remove(new R1(-2)));
		System.out.println(ts);
		System.out.println(ts.remove(new R1(5)));
		System.out.println(ts);
		
	}
}
