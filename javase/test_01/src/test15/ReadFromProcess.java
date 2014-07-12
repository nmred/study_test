package test15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
	public static void main(String[] args) throws IOException
	{
		Process p = Runtime.getRuntime().exec("java");
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream())))
		{
			String buffer = null;
			while((buffer = br.readLine()) != null) {
				System.out.println(buffer);
			}
		}
	}
}
