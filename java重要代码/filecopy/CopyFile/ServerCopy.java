package CopyFile;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCopy {
    public static void main(String [] args) {
    	ServerSocket server=null;
    	Socket client=null;
		try {
			server = new ServerSocket(9999);
			 client =server.accept();
			 System.out.println("客户端连接成功！！");
			 String strFile1="D:\\矩阵.txt";
			 File file=new File(strFile1);
			 FileInputStream fileInputStream=new FileInputStream(strFile1);
			 DataInputStream in =new DataInputStream(fileInputStream);
			 DataOutputStream out =new DataOutputStream(client.getOutputStream());
			 out.writeUTF(file.getName()+"  "+(file.length())+"B");
			 
			 int len=0;
			byte[] data=new byte[1024];
			 while((len=in.read(data))!=-1) {
				 out.write(data, 0, len);
				 out.flush();
			 }
			 
			 
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				server.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
    }
}
