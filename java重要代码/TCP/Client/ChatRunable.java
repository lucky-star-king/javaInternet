package Client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;
import java.util.ArrayList;

public class ChatRunable implements Runnable{
	String user=null;
	Socket client=null;
	public ChatRunable(String user,Socket client) {
		// TODO Auto-generated constructor stub
		this.user=user;
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			SocketThread socketThread=new SocketThread(client, user);
			ChatFrame frame = new ChatFrame(socketThread);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					super.windowClosed(e);
					String mess="EXIT|"+socketThread.getname();
					socketThread.sendMe(mess);
				}
			});
			frame.setVisible(true);
		  frame.lblNewLabel.setText(user);
		  socketThread.setframe(frame);
			socketThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void setList() {
//		for(SocketThread n:ClientMG.getClientMG().getArrayList()) {
//			frame.itemList.addElement(n.getname());
//		
//		}
		
	//}
}
