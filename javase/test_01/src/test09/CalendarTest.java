package test09;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH));
		System.out.println(calendar.get(calendar.DATE));
		
		calendar.set(2003, 10, 23, 12, 32, 23);
		System.out.println(calendar.getTime());
		calendar.add(calendar.YEAR, -1);
		calendar.roll(calendar.MONTH, -8);
		System.out.println(calendar.getTime());
	}
}
