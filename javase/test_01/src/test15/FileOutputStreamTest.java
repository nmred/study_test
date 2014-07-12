package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args)
	{
		try (
			FileInputStream fis = new FileInputStream("mysql.ini");
			FileOutputStream fos = new FileOutputStream("newFile.txt"))
		{
			byte[] bbuf = new byte[32];
			int hadRead = 0;
			while((hadRead = fis.read(bbuf)) > 0) {
				fos.write(bbuf, 0, hadRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
