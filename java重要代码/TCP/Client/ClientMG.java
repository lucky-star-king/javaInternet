package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ClientMG {
	private static final ClientMG clientmg =new ClientMG();
	private ClientMG() {}
	//存储客户端线程
	private  HashSet<String> Socketlist=new HashSet<>();
	public static ClientMG getClientMG() {
		return clientmg;
	}
	private ClientForm win;
    private	SocketThread newSocket;
	public void  setWinForm(ClientForm w) {
		this.win = w;
	}
	public HashSet<String> getArrayList() {
		return Socketlist;
	}
	//向Arrayllist添加客户端线程
	public void AddSocket(String socketThread) {
		Socketlist.add(socketThread);
	}

	//在List中添加用户
	public void AddUser(int i,String user) {
		win.itemUsers.add(i,user);
	}

	public void SendMessage1() {
		
	}
	
}
