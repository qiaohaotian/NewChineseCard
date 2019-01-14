package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
public class Client {
	public static void main(String[] args) {
		if (args.length == 0) {
			return;
		}
		String serverName;
		serverName = args[0];
		try {
			System.out.println("请输入用户名和密码用空格隔开");
			String a =null;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				a = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Socket client = new Socket(serverName, 6666);
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			Player player = new Player();
			out.writeUTF(a);
			DataInputStream in = new DataInputStream(client.getInputStream());
			String inStr = in.readUTF();
			ArrayList<Card> handcard = Rules.transformArr(inStr);
			player.sethandcards(handcard);
			out.writeUTF("ok");
			while(true/*那边没说胡了*/){
				inStr = in.readUTF();
				handcard = Rules.transformArr(inStr);
				player.ShowCards();
				System.out.println("打牌请输入序号");
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					a = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.writeUTF(a);
				int i = Integer.parseInt(a);
				player.playCard(i);
				player.ShowCards();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 登陆游戏
	// 用户名
	// 拿起始手牌
	// 选择行动
	// 打牌
}
