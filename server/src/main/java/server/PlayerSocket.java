package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PlayerSocket  {
	private Socket socket;
	public PlayerSocket(Socket socket) throws IOException {
		this.socket = socket;
	}


}
