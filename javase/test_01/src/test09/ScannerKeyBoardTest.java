package test09;

import java.util.Scanner;

public class ScannerKeyBoardTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			System.out.println("键盘输入的内容是:" + scanner.next());
		}
	}
}
