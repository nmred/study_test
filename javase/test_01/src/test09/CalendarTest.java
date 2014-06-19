package test09;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar =Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		
		calendar.set(2003, 10, 23, 12, 32, 23);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.YEAR, -1);
		calendar.roll(Calendar.MONTH, -8);
		System.out.println(calendar.getTime());
	}
}
