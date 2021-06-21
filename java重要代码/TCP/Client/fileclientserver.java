package Client;

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

public class fileclientserver extends Thread{
	int port;
	DataInputStream in=null;
	Socket client=null;
	String filename=null;
	FileOutputStream fileOutputStream;
	public fileclientserver(int po,String filename){
		this.filename=filename;
		this.port=po;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			 client=new Socket("localhost", port);
			in =new DataInputStream(client.getInputStream());
			File file=new File("D:\\copy-"+filename);
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
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				client.shutdownOutput();
				client.close();
				client.shutdownInput();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		
		

}
