package test07;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
	public static void main(String[] args) {
		ArrayList numsArrayList = new ArrayList();
		numsArrayList.add(2);
		numsArrayList.add(-5);
		numsArrayList.add(3);
		numsArrayList.add(0);
		System.out.println(numsArrayList);
		Collections.reverse(numsArrayList);
		System.out.println(numsArrayList);
		Collections.sort(numsArrayList);
		System.out.println(numsArrayList);
		Collections.shuffle(numsArrayList);
	}
}
