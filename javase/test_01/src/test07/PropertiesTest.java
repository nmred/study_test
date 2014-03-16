package test07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class PropertiesTest {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.setProperty("username", "yeeku");
		props.setProperty("password", "123456");
		props.store(new FileOutputStream("a.ini"), "commect line");
		
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}
}
