import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class clientFrame extends JFrame {

	private JPanel contentPane;
	public JPanel load_panel;
	public JPanel send_panel;
	public JLabel lblNewLabel;
	public JTextField textField;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JTextField textField_1;
	public JLabel lblNewLabel_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JLabel lblNewLabel_2;
	public JTextField textField_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JTextField textField_3;
	public JTextField textField_4;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientFrame frame = new clientFrame();
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
	public clientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		load_panel = new JPanel();
		load_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u767B\u5F55\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		load_panel.setBounds(10, 0, 647, 109);
		contentPane.add(load_panel);
		load_panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("服务器IP\r\n");
		lblNewLabel_3.setBounds(10, 42, 58, 33);
		load_panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("端口：");
		lblNewLabel_4.setBounds(162, 42, 41, 33);
		load_panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(62, 42, 90, 33);
		load_panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(199, 42, 90, 33);
		load_panel.add(textField_4);
		
		btnNewButton_4 = new JButton("登录");
		btnNewButton_4.addActionListener(new BtnNewButton_4ActionListener());
		btnNewButton_4.setBackground(SystemColor.controlHighlight);
		btnNewButton_4.setBounds(327, 42, 104, 31);
		load_panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("退出");
		btnNewButton_5.addActionListener(new BtnNewButton_5ActionListener());
		btnNewButton_5.setBackground(SystemColor.controlHighlight);
		btnNewButton_5.setBounds(462, 42, 104, 31);
		load_panel.add(btnNewButton_5);
		
		send_panel = new JPanel();
		send_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		send_panel.setBounds(10, 130, 647, 219);
		contentPane.add(send_panel);
		send_panel.setLayout(null);
		
		lblNewLabel = new JLabel("操作数1\r\n");
		lblNewLabel.setBounds(40, 49, 58, 31);
		send_panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(108, 49, 197, 31);
		send_panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("加法（+）");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(361, 49, 104, 31);
		send_panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("减法（-）");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setBounds(498, 49, 104, 31);
		send_panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 119, 197, 31);
		send_panel.add(textField_1);
		
		lblNewLabel_1 = new JLabel("操作数2\r\n");
		lblNewLabel_1.setBounds(40, 119, 58, 31);
		send_panel.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("除法（/）");
		btnNewButton_2.addActionListener(new BtnNewButton_2ActionListener());
		btnNewButton_2.setBackground(SystemColor.controlHighlight);
		btnNewButton_2.setBounds(498, 119, 104, 31);
		send_panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("乘法（*）");
		btnNewButton_3.addActionListener(new BtnNewButton_3ActionListener());
		btnNewButton_3.setBackground(SystemColor.controlHighlight);
		btnNewButton_3.setBounds(361, 119, 104, 31);
		send_panel.add(btnNewButton_3);
		
		lblNewLabel_2 = new JLabel("计算结果");
		lblNewLabel_2.setBounds(40, 178, 58, 31);
		send_panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 178, 197, 31);
		send_panel.add(textField_2);
		
		lblNewLabel_5 = new JLabel("双击操作");
		lblNewLabel_5.setBounds(448, 160, 79, 31);
		send_panel.add(lblNewLabel_5);
	}
	
	
	//客户端线程
	private class sockThread extends Thread{
Socket client=null;
PrintWriter ou=null;
BufferedReader in=null; 
 public sockThread(Socket client) {
	// TODO Auto-generated constructor stub
	this.client=client;
}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 try {
				 ou=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8" )));
				in=new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
				String readline=null;
				if(!client.isClosed()) {
				  while((readline=in.readLine())!=null) {
					  textField_2.setText(in.readLine());
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

		}
		public void sendmess(String str) {
			ou.println(str);
			ou.flush();
		}
		
		
	}
//登录按钮监听器
	Socket client=null;
	sockThread clientThread=null;
	public JLabel lblNewLabel_5;
	private class BtnNewButton_4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				 client=new Socket(textField_3.getText().trim(),Integer.parseInt(textField_4.getText().trim()));
				clientThread=new sockThread(client);
				clientThread.start();
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}
	//退出按钮监听器
	private class BtnNewButton_5ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		try {
			client.shutdownInput();
			client.shutdownOutput();
			client.close();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//pass
		}	
		}
	}
	//加法按钮
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		  String str="+|"+textField.getText()+"|"+textField_1.getText();
		  if(clientThread!=null)
		  clientThread.sendmess(str);
		}
	}
	//减法按钮
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 String str="-|"+textField.getText()+"|"+textField_1.getText();
			 if(clientThread!=null)
			 clientThread.sendmess(str);
		}
	}
	//乘法按钮
	private class BtnNewButton_3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 String str="*|"+textField.getText()+"|"+textField_1.getText();
			 if(clientThread!=null)
			 clientThread.sendmess(str);
		}
	}
	//除法按钮
	private class BtnNewButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 String str="/|"+textField.getText()+"|"+textField_1.getText();
			 clientThread.sendmess(str);
		}
	}
}

