package test09;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneTest {
	public static void  main(String[] args) {
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));   
		TimeZone my = TimeZone.getDefault();
		System.out.println(my.getID());
		System.out.println(my.getDisplayName());
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
	}
}
