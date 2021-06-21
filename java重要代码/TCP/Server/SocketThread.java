package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class SocketThread extends Thread {
	String AllUsers="";
	  Socket client1=null;
		 PrintWriter ou=null;
		 BufferedReader in=null;
		 ObjectInputStream objectin=null;
	 public SocketThread(Socket socket) {
			 this.client1=socket;
		 }
	public static void SendSocketMess(Socket client,String Stri,String sendside) {
		PrintWriter ouu=null;
//		 BufferedReader inn=null;
		 try {
			 ouu=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8" )));
//			in=new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
			ouu.println(sendside+":"+Stri);
			ouu.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		 
	}
  //发送给所有服务器消息
	public static void SendSocketMess(Socket client,String Stri) {
		PrintWriter ouu=null;
		 try {
			 ouu=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8" )));
			ouu.println(Stri);
			ouu.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		 
	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			  try {
				in=new BufferedReader(new InputStreamReader(client1.getInputStream(),"UTF-8"));
				 ou=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client1.getOutputStream(),"UTF-8" )));
				  String read=null;
				  ou.println("初始化成功！");
				  ou.flush();
				  if(!client1.isClosed()) {
				  while((read=in.readLine())!=null) {
					  if(read.equals("END"))
						  break;
					  ServerMG.getSmg().setTextlog(read);
					  String[] commands=read.split("\\|");
					  String protocol=commands[0];
					  
					  if(protocol.equals("MESS")) {
					  String Message=commands[1];
					  String sendside=commands[2];
					  String acceptside=commands[3];		
                    		  SendSocketMess(ServerMG.getSmg().getSocketlist().get(ServerMG.getSmg().getuserlist().indexOf(acceptside)), Message,sendside);
				  }else if(protocol.equals("LOGIN")) {
					  ServerMG.getSmg().AddUser(commands[1]);
						 ServerMG.getSmg().setTextlog(commands[1]+"已经上线！");
						 String  AllUsers="";
							for(String  n:ServerMG.getSmg().getuserlist()) {
								AllUsers+=n+"_";
							}
						for(Socket client:ServerMG.getSmg().getSocketlist()) {
							 SendSocketMess(client, "ADD|"+AllUsers);
						}
				  }else if(protocol.equals("ALL")) {
					  String Message=commands[1];
					  String sendside=commands[2];
					  for(Socket client:ServerMG.getSmg().getSocketlist()) {
						  SendSocketMess(client, Message,sendside);						}
                    		 
				  }else if(protocol.equals("EXIT")) {
					  ServerMG.getSmg().getuserlist().remove((String)commands[1]);
					for(Socket client:ServerMG.getSmg().getSocketlist()) {
						 SendSocketMess(client, "REMOVE|"+commands[1]);
					}
					ServerMG.getSmg().getSocketlist().get(ServerMG.getSmg().getuserlist().indexOf(commands[1])).close();
				  }else if(protocol.equals("FILETRANS")) {
					  String sendside=commands[1];
					  String acceptside=commands[2];
//					String[]  fileinfo=commands[3].split("#");
					  SendSocketMess(ServerMG.getSmg().getSocketlist().get(ServerMG.getSmg().getuserlist().indexOf(acceptside)),"FILETRANS|"+sendside+"|"+commands[3]);
				  } 	  
					  }
				  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {	
				
				
			         }
		 
		}//run
		  
}
