package Client;

import java.awt.EventQueue;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {

	private Socket client=null;
	String name="";
	PrintWriter out=null;
	BufferedReader in=null;
	ObjectOutputStream objectout=null;
    private ChatFrame frame;
	public SocketThread(Socket client,String name) {
		this.name=name;
		this.client=client;
	}
	public void setframe(ChatFrame frame) {
		this.frame=frame;
	}
	public Socket getSocket() {
		return client;
	}
	public String getname() {
		return name;
	}
	public void run() {
		try {
//           objectout=new ObjectOutputStream(client.getOutputStream());
			//EventQueue.invokeLater(chRunable);
			out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));
			in=new BufferedReader(new InputStreamReader(client.getInputStream()));
//			sendMe(this);
		    out.println("LOGIN|"+name);
		    out.flush();
			if(!client.isClosed()) {
				//frame.textArea.append(readline+"\n");
				new readmess(in, frame).start();
				  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	//传递线程
//	public void sendMe(SocketThread socketclient) {
//		 try {
//			objectout.writeObject(socketclient);
//			objectout.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		    
//	}
	//发送消息
	public  void sendMe(String str) {
		out.println(str);
		out.flush();
	}
}
class readmess extends Thread{
	String readline=null;
	ChatFrame frame=null;
	public BufferedReader in=null;
	public readmess(BufferedReader in,ChatFrame frame) {
		this.in=in;
		this.frame=frame;
	}
	public void run() {
	  try {
		while((readline=in.readLine())!=null) {
			 String info[]=readline.split("\\|");
			 if(info[0].equals("ADD")) {
				 String userr[]=info[1].split("_");
				 for(int i=0;i<userr.length;i++) {
					 ClientMG.getClientMG().getArrayList().add(userr[i]);
					 frame.Refreashlist();
				 }
			 }else if((info[0].equals("REMOVE"))){
				 
				 ClientMG.getClientMG().getArrayList().remove((String)info[1]);
				 frame.Refreashlist();
			 }else if(info[0].equals("CLOSE")) {
				 frame.textArea.append(info[1]+"\n");
				 
			 }else if(info[0].equals("FILETRANS")) {
              String[] fileinfo1=info[2].split("#");
              String filename=fileinfo1[0];
              String filelength=fileinfo1[1];
              String fileIP=fileinfo1[2];
              String filport=fileinfo1[3];
			   frame.confimmess(info[1]);
			   new fileclientserver(Integer.parseInt(filport),filename).start();
			   frame.textArea.append("开始接收文件"+"\n");
			 }
			 else {
				 frame.textArea.append(readline+"\n");
			 }
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

