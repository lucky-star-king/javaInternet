import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpServer {
	public static void main(String args[])throws NumberFormatException {
		int port=9000;
		InetAddress IP=null;
		DatagramSocket Server=null;
		try {
			IP = InetAddress.getByName("localhost");
			Server=new DatagramSocket(port, IP);
			System.out.println("服务器已经创建!");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
		try {
			byte[] infobyte=new byte[1024];
			DatagramPacket info=new DatagramPacket(infobyte, infobyte.length);
			Server.receive(info);
		String[] infolist=new String(infobyte).split("#");
		String resultStr=null;
			if(infolist[0].equals("+")){
				resultStr=String.valueOf(Integer.valueOf(infolist[1].trim())+Integer.valueOf(infolist[2].trim()));
			}else if(infolist[0].equals("-")) {
				resultStr=String.valueOf(Integer.parseInt(infolist[1].trim())-Integer.parseInt(infolist[2].trim()));
			}else if(infolist[0].equals("*")) {
				resultStr=String.valueOf(Integer.parseInt(infolist[1].trim())*Integer.parseInt(infolist[2].trim()));
			}else if(infolist[0].equals("/")) {
				resultStr=String.valueOf(Double.parseDouble(infolist[1].trim())/Double.parseDouble(infolist[2].trim()));
			}
			DatagramPacket result =new DatagramPacket(resultStr.getBytes(), resultStr.getBytes().length,info.getAddress(),info.getPort());
			Server.send(result);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	}


