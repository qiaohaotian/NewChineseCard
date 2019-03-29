package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import org.omg.CORBA.portable.OutputStream;

import static server.Win.ishule;

public class Table {
	private ArrayList<Player> players;
	private ArrayList<Socket> sockets = new ArrayList<Socket>();
	private Cardset cardset = new Cardset();
	private Card lastcard =null;
	public Table() {
		players = new ArrayList<Player>();
		cardset.create();
	}

	public boolean isfull() {
		if (players.size() < 4) {
			return false;
		}
		return true;
	}

	public ArrayList<Player> getplayers() {
		return players;
	}

	public void addplayers(Player player) {
		players.add(player);
	}

	public void start() {
		int turn = 0;
		try{
			for (int i = 0; i < 3; i++) {
				DataInputStream in = new DataInputStream(sockets.get(i).getInputStream());
				DataOutputStream out = new DataOutputStream(sockets.get(i).getOutputStream());
				String instr = in.readUTF();
				Player player = new Player(instr);
				players.add(player);
				players.get(i).sethandcards(cardset.firstDraw());
				players.get(i).ShowCards();
				String outStr = Rules.transformStr(players.get(i).gethandcards());
				out.writeUTF(outStr);
				out.flush();
				}
			while (cardset.getsize() > 0 && !ishule(players.get(turn).gethandcards())/* 桌面上还有牌可抓且没有玩家胡了 */) {
				// if判断是不是第一个以及玩家行动
				DataInputStream in = new DataInputStream(sockets.get(turn).getInputStream());
				DataOutputStream out = new DataOutputStream(sockets.get(turn).getOutputStream());
				String intr = in.readUTF();
				players.get(turn).drawCard(cardset.randomCard());
				String outStr = Rules.transformStr(players.get(turn).gethandcards());
				out.writeUTF(outStr);
				out.flush();
				System.out.println("player"+turn+":");
				players.get(turn).ShowCards();
				intr = in.readUTF();
				int i = Integer.parseInt(intr);
				lastcard = players.get(turn).playCard(i);
				cardset.gether(lastcard);
				// players.move;玩家操作
				/* 根据玩家操作来调整顺序用switch */
				if (turn < 3) {
					turn++;
				} else {
					turn = turn - 3;
				}
			}
		}
		catch(IOException e)
        {
           e.printStackTrace();
        }
	}

	public void addplayerSocket(Socket player) {
		sockets.add(player);
	}
}
