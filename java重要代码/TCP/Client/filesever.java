package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class filesever {
    int port;
    String IP="localhost";
	public String filepath=null;
	public filesever(String filepath,int port){
      this.filepath=filepath;
      this.port=port;
	}
	public  String getIP() {
		return IP;
	}
	public void startfiletrans() {
		new filetrans().start();
	}
    private class filetrans extends Thread{
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		super.run();
        	ServerSocket server=null;
        	Socket client=null;
    		try {
    			server = new ServerSocket(port);
    			 client =server.accept();
    			 System.out.println("客户端连接成功！！");
    			 String strFile1=filepath;
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
}
