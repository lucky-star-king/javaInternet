import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class UdpClient extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JPanel panel_1;
	public JLabel lblNewLabel;
	public JTextField txtLocalhost;
	public JLabel lblNewLabel_1;
	public JTextField textField_1;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
    public DatagramSocket Client=null;
	InetAddress IP=null;
	int port=80;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UdpClient frame = new UdpClient();
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
	public UdpClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u767B\u5F55\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 737, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("服务器IP：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 38, 100, 42);
		panel.add(lblNewLabel);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setFont(new Font("宋体", Font.PLAIN, 15));
		txtLocalhost.setBounds(120, 38, 115, 42);
		panel.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		lblNewLabel_1 = new JLabel("端口：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(245, 38, 60, 42);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(298, 38, 115, 42);
		panel.add(textField_1);
		
		btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(435, 38, 100, 42);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(555, 38, 100, 42);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 130, 737, 355);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("操作数1");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 84, 100, 42);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("操作数2");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(44, 148, 100, 42);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("计算结果");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(44, 232, 100, 42);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 84, 197, 42);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(150, 150, 197, 42);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(150, 234, 197, 42);
		panel_1.add(textField_4);
		
		btnNewButton_2 = new JButton("加法");
		btnNewButton_2.addActionListener(new BtnNewButton_2ActionListener());
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(450, 84, 100, 42);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("乘法");
		btnNewButton_3.addActionListener(new BtnNewButton_3ActionListener());
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(450, 197, 100, 42);
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("减法");
		btnNewButton_4.addActionListener(new BtnNewButton_4ActionListener());
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(592, 84, 100, 42);
		panel_1.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("除法");
		btnNewButton_5.addActionListener(new BtnNewButton_5ActionListener());
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setBounds(592, 197, 100, 42);
		panel_1.add(btnNewButton_5);
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//登录按钮
        try {
			IP=InetAddress.getByName(txtLocalhost.getText().trim());
			 port=Integer.parseInt(textField_1.getText().trim());
			Client=new DatagramSocket();
			System.out.println("客户端已经创建！");
			Runnable run=()->{
				while(true) {
			byte [] receive=new byte[1024];
			DatagramPacket pac=new DatagramPacket(receive, receive.length);
			try {
				Client.receive(pac);
				System.out.println("已经收到一条消息");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textField_4.setText(new String(receive));
				}
			};
			new Thread(run).start();
	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		}
	}
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//退出按钮 
			textField_4.setText("程序已经退出");
			Client.close();
		}
	}
	private class BtnNewButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//加法按钮
			String op1=textField_2.getText().trim();
		    String op2=textField_3.getText().trim();
			String messStr="+#"+op1+"#"+op2;
			DatagramPacket mess=new DatagramPacket(messStr.getBytes(), messStr.getBytes().length,IP,port);
			try {
				Client.send(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnNewButton_4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//减法按钮
			String messStr="-#"+textField_2.getText().trim()+"#"+textField_3.getText().trim();
			DatagramPacket mess=new DatagramPacket(messStr.getBytes(), messStr.getBytes().length,IP,port);
			try {
				Client.send(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnNewButton_3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//乘法按钮
			String messStr="*#"+textField_2.getText().trim()+"#"+textField_3.getText().trim();
			DatagramPacket mess=new DatagramPacket(messStr.getBytes(), messStr.getBytes().length,IP,port);
			try {
				Client.send(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnNewButton_5ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//除法按钮
			String messStr="/#"+textField_2.getText().trim()+"#"+textField_3.getText().trim();
			DatagramPacket mess=new DatagramPacket(messStr.getBytes(), messStr.getBytes().length,IP,port);
			try {
				Client.send(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
