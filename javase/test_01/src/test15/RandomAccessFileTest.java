package test15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args)
	{
		try (
			RandomAccessFile raf = new RandomAccessFile("src/test15/RandomAccessFileTest.java", "r"))
		{
			System.out.println("RandomAccessFile 的文件指针的初始位置是 ：" + raf.getFilePointer());
			
			raf.seek(300);
			byte[] bbuf = new byte[1024];
			int hadRead = 0;
			while((hadRead = raf.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hadRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
