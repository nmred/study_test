package test09;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
	public static void main(String[] args) throws Exception{
		Map<String, String> env= System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "--->" + env.get(name));
		}
		System.out.println(System.getenv("JAVA_HOME"));
		
		Properties prop = System.getProperties();
		prop.store(new FileOutputStream("prop.txt"), "System Properties");
		System.out.println(System.getProperty("os.name"));
	}
}
