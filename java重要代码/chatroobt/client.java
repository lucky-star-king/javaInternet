
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
public class client {
 public static void main(String [] args) throws IOException {
//	 ServerSocket serverSocket =null;
	 Socket client1=null;
	 PrintWriter ou=null;
	 BufferedReader in=null; 
	 BufferedReader inkey=null;
	 try {
//		 serverSocket =new ServerSocket(9999);
//		 System.out.println("服务器创建成功!");
		  client1=new Socket("localhost",8877);
		  System.out.println("服务器连接成功\n"+client1);
		  in=new BufferedReader(new InputStreamReader(client1.getInputStream(),"UTF-8"));
		  inkey=new BufferedReader(new InputStreamReader(System.in));
		  ou=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client1.getOutputStream(),"UTF-8" )));
		  String readline=null;
		  while((readline=inkey.readLine())!=null) {
			  if(readline.equals("Q"))
				  break;
			  ou.println(readline);
			  ou.flush();
//			  String read= 
			  System.out.println(in.readLine());
		  }
		  
//		  ou.println("滴滴滴滴——————————");
//		  ou.flush();
//		String read= in.readLine();
//		System.out.println("反馈信息："+read);
//		
		
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		in.close();
		ou.close();
		client1.close();
		
	}
	 
 }
}
