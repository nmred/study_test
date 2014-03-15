package test07;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {
	public static void main(String[] args) {
		List fixedList = Arrays.asList("疯狂Java讲义", "轻量级Java EE 企业应用实战");
		System.out.println(fixedList.getClass());
		for(int i = 0, len = fixedList.size(); i < len; i++) {
			System.out.println(fixedList.get(i));
		}
	}
}
