package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class serverListener extends Thread {
	ServerSocket serversocket;
	public serverListener(ServerSocket serversocket) {
		this.serversocket=serversocket;
	}
	public 	boolean flag=true;
	@Override
	public void run() {
		 while(flag) {
			 Socket client;
			try {
				client = serversocket.accept();
				if(client!=null)
					ServerMG.getSmg().AddSocket(client);
			    ServerMG.getSmg().setTextlog("客户端连接成功！"+client);
			//	System.out.println("客户端连接成功！！");
				SocketThread socketThread= new SocketThread(client);
				socketThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				}		
			}
	
	}
	public void setflag() {
		flag=false;
	}
}
