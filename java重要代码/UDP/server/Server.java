//服务器端
package server;
import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
 
 
public class Server extends JFrame implements Runnable {
     private Socket s=null;
     private ServerSocket ss=null;
     private ArrayList<ChatThread> clients=new ArrayList<ChatThread>();//保存每个客户端连入的变长数组
	
     public Server()throws Exception{
    	 this.setTitle("服务器端");
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setBackground(Color.yellow);
    	 this.setSize(200, 100);
    	 this.setVisible(true);
    	 ss=new ServerSocket(9999);//服务器开辟一个端口
    	 new Thread(this).start();//接受客户连接的死循环开始运行 
     }
     
	//run函数的重写
     //此线程是用来接收等待客户端不断连入时的线程
	public void run() {
		try {
			while(true)
			{
				s=ss.accept();//等待连入
				ChatThread ct=new ChatThread(s);//当有客户端连入后，为此客户端创建一个线程
				clients.add(ct);//并且将此线程加入到线程数组中
				ct.start();//启动此线程的线程，此后可以实现通信
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(this, "游戏异常退出！");
			System.exit(0);
		}
		
	}
	//类中类的建立，此线程来接收服务器和一个客户端的通信的线程 （针对于服务器）
	class ChatThread extends Thread{
		private Socket s=null;
		private BufferedReader br=null;
		private PrintStream ps=null;
		private boolean canRun=true;
		
		public ChatThread(Socket s)throws Exception
		{//利用线程实现输入输出（通信）
			this.s=s;
			br=new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			ps=new PrintStream(s.getOutputStream());
		}
		
		public void run() {//把从客户那里得到的信息，穿送给其他客户
			try {
				while(canRun) {
					String str=br.readLine();//读取该Socket传来的信息，
					System.out.println(str);
					sendMessage(str);
					
				}
			}catch (Exception ex) {
				canRun=false;
				clients.remove(this);//将此线程从客户端的数组中删除
			}
		}
	}
	//将信息发送给其他的客户端，实现客户端之间的通信
	public void sendMessage(String msg) {
		for(ChatThread ct: clients) {
			ct.ps.println(msg);
		}
	}
	
	public static void main(String[] args) throws Exception {
         Server server=new Server();
 
	}
}