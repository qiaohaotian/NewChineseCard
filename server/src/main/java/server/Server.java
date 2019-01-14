package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;

	public Server() throws IOException {
	}

	public void start() throws IOException {
		Table table = new Table();
		int count = 0;
		ServerSocket server= new ServerSocket(6666);
		while (count < 4 ) {
			try {
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress().getHostAddress()
                    + "连接进入");
			table.addplayerSocket(socket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		table.start();
	}

	public static void main(String args[]) throws IOException {
			Server server = 
					new Server();
			server.start();
	}
}
