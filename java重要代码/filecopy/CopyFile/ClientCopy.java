package CopyFile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientCopy {

	public static void main(String [] args) throws Exception {
		
		Socket client=new Socket("localhost", 9999);
		DataInputStream in =new DataInputStream(client.getInputStream());
		 FileOutputStream fileOutputStream;
		try {
			File file=new File("D:\\a.txt");
			if(!file.exists())
				file.createNewFile();
			fileOutputStream = new FileOutputStream(file);
			 DataOutputStream out =new DataOutputStream(fileOutputStream);
			 System.out.print(in.readUTF());
			 
			 int len=0;
			 byte[] dataread=new byte[1024];
			 while((len=in.read(dataread))!=-1) {
				 out.write(dataread,0,len);
				 out.flush();
			 }
			 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			client.shutdownInput();
			client.shutdownOutput();
			client.close();
		}
		
		
		
		
		
		
	}
}
