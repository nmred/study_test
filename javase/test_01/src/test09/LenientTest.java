package test09;

import java.util.Calendar;

public class LenientTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.MONTH, 13);
		
		//calendar.setLenient(false);
		
		//calendar.set(calendar.MONTH, 13);
		
		System.out.println(calendar.getTime());
	}
}
