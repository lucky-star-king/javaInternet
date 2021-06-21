import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.io.PrintWriter;
	import java.net.*;
	public class server {
	 public static void main(String [] args) throws IOException {
		 ServerSocket serverSocket =null;
		 Socket client=null;
		 try {
			 serverSocket =new ServerSocket(8877);
			 System.out.println("服务器创建成功!");
			 while(true) {
				 client=serverSocket.accept();
				  System.out.println("客户端连接成功"+client);
				  new Thread(new Runclient(client)).start();
			 }
			
			
//			String read= in.readLine();
//			System.out.println("客户端发送数据:"+read);
//			
//			ou.write("已经收到你的消息了");
//			 ou.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			serverSocket.close(); 
			client.close();
			
		}
		 
	 }
	 
	 public static class Runclient implements Runnable{
	      Socket client1=null;
		 PrintWriter ou=null;
		 BufferedReader in=null;
	 public Runclient(Socket socket) {
			 this.client1=socket;
		 }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			  try {
				in=new BufferedReader(new InputStreamReader(client1.getInputStream(),"UTF-8"));
				 ou=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client1.getOutputStream(),"UTF-8" )));
				  String read=null;
				  while((read=in.readLine())!=null) {
					  if(read.equals("END"))
						  break;
					  String[] commands=read.split("\\|");
					  //!read.matches("[0-9]+");
					  if(commands[0].equals("chat")) {
						  ou.println(new HashRoobt().Getmessage(commands[1]));
						  ou.flush();
						  System.out.println("客户端发送数据:"+read);
					  }else {
					  System.out.println("客户端发送数据:"+read);
					  if(Integer.parseInt(commands[1])%2==0) {
						  ou.println("已经收到你的消息了："+commands[1]+"是偶数");
						  ou.flush();
					  }else {
						  ou.println("已经收到你的消息了："+commands[1]+"是奇数");
						  ou.flush();
					  }
					  }
				  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
					in.close();
					ou.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			         }
		 
		}//run
		  
	 }//Run 类
	 
	}

	
	

