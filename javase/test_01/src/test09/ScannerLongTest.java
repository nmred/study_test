package test09;

import java.util.Scanner;

public class ScannerLongTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLong()) {
			System.out.println("键盘输入的内容是：" + scanner.nextLong());
		}
		scanner.close();
	}
}
