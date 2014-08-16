package test17.HalfClose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("127.0.0.1", 30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("test.....");
		
		try {
			if (br != null) {
				br.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
