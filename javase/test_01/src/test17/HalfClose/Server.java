package test17.HalfClose;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		ps.println("服务器的第一行数据");
		ps.println("服务器的第二行数据");
		
		socket.shutdownOutput();
		System.out.println(socket.isClosed());
		Scanner scan = new Scanner(socket.getInputStream());
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
		
		scan.close();
		socket.close();
		ss.close();
	}
}
