package test15;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args)
	{
		try (
			FileWriter fw = new FileWriter("poem.txt")
		) {
			fw.write("锦瑟 - 李商隐\r\n");
			fw.write("锦瑟无端五十弦，一些一柱思年华\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
