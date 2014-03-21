package test10;

public class MultiExceptionTest {
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是：" + c);
		} catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException e) {
			System.out.println("test");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}
}
