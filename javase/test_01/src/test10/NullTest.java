package test10;

import java.util.Date;

public class NullTest {
	public static void main(String[] args) {
		Date date = null;
		try {
			System.out.println(date.after(new Date()));
		} catch (NullPointerException e) {
			System.out.println("空指针异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}
}
