package test15;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args)
	{
		try (FileReader fr = new FileReader("mysql.ini")) {
			char[] cbuf = new char[32];
			int hadRead = 0;
			while((hadRead = fr.read(cbuf)) > 0) {
				System.out.println(new String(cbuf, 0, hadRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
