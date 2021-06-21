import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import org.w3c.dom.Text;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ServerFrame extends JFrame {
	 ServerSocket serverSocket =null;
	 ArrayList<Socket> clientlist2=new ArrayList<Socket>();
	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblNewLabel;
	public JTextField textField;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JScrollPane scrollPane;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u914D\u7F6E\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 25, 635, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("端口号\r\n");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 23, 60, 44);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 23, 104, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("开启服务器\r\n");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(243, 23, 121, 44);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("关闭服务器");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(433, 23, 121, 44);
		panel.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "\u6D88\u606F\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 132, 615, 408);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	//监听客户端线程
	private class clientlistener1 extends Thread{
	public 	boolean flag=true;
		@Override
		public void run() {
			 while(flag) {
				 Socket client;
				try {
					client = serverSocket.accept();
					if(client!=null)
					clientlist2.add(client);
					  System.out.println("客户端连接成功"+client);
					  textArea.append("客户端连接成功"+client);
					  new Thread(new Runclient(client)).start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 }
		
		}
		public void setflag() {
			flag=false;
		}
	}
	clientlistener1 clientlisten=null;
	//开启服务器
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			 try {
				 serverSocket =new ServerSocket(Integer.parseInt(textField.getText().trim()));
				 textArea.append("服务器已经创建！！！"+"\n");
				 clientlisten=new clientlistener1();
				clientlisten.start();
//				clientlisten.join();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				
		}
	}
	}
	//关闭服务器，以及与其相连的客户端
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				clientlisten.setflag();
				serverSocket.close();
				for(Socket sock:clientlist2) {
					sock.shutdownInput();
					sock.shutdownOutput();
					sock.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			
		}
	}
	//服务器线程
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
				  if(!client1.isClosed()) {
				  while((read=in.readLine())!=null) {
					  if(read.equals("END"))
						  break;
					  String[] commands=read.split("\\|");
					  int operate1=Integer.parseInt(commands[1]);
					  int operate2=Integer.parseInt(commands[2]);
					  //!read.matches("[0-9]+");
					  if(commands[0].equals("+")) {
						  ou.println(operate1+operate2);
						  ou.flush();
					  }else if(commands[0].equals("-") ){
						  ou.println(operate1-operate2);
						  ou.flush();
						  
					  }else if(commands[0].equals("*") ){
						  ou.println(operate1*operate2);
						  ou.flush();
						  
					  }else if(commands[0].equals("/")) {
						  ou.println(operate1/operate2);
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