package test15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
	public static void main(String[] args)
	{
		String src = "从明天起，做一个幸福的人\n"
				+ "喂马，劈材，周游世界\n"
				+ "我有一所房子，面朝大海\n";
		char[] buffer = new char[32];
		int hadRead = 0;
		try (
			StringReader sr = new StringReader(src))
		{
			while ((hadRead = sr.read(buffer)) > 0) {
				System.out.println(new String(buffer, 0, hadRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (
			StringWriter sw = new StringWriter())
		{
			sw.write("有一个美丽的新世界\n");
			sw.write("那里有天真的孩子\n");
			System.out.println("----下面是sw字符串里的内容-----");
			System.out.println(sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
