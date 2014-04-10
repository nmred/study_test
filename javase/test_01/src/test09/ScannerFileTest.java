package test09;

import java.io.File;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("ScannerFileTest.java"));
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}
}
