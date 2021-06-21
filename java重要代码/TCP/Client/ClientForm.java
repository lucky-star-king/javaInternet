package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import Client.ClientMG;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
public class ClientForm extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblIp;
	public JTextField textIP;
	public JLabel label;
	public JTextField textPort;
	public JButton btnLogin;
	//PrintWriter pw=null;
//	ClientChat sThd;
	public JLabel label_1;
	public JTextField textUser;
	/**
	 * Launch the application.
	 */
	
	DefaultListModel<String> itemUsers;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm frame = new ClientForm();
					frame.setVisible(true);
					ClientMG.getClientMG().setWinForm(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientForm() {
		setTitle("\u5BA2\u6237\u7AEF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u7528\u6237\u767B\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 501, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblIp = new JLabel("IP");
		lblIp.setBounds(10, 29, 54, 15);
		panel.add(lblIp);
		
		textIP = new JTextField();
		textIP.setText("localhost");
		textIP.setBounds(34, 26, 109, 21);
		panel.add(textIP);
		textIP.setColumns(10);
		
		label = new JLabel("\u7AEF\u53E3");
		label.setBounds(147, 29, 54, 15);
		panel.add(label);
		
		textPort = new JTextField();
		textPort.setBounds(180, 26, 66, 21);
		panel.add(textPort);
		textPort.setColumns(10);
		
		btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new BtnLoginActionListener());
		btnLogin.setBounds(369, 25, 122, 23);
		panel.add(btnLogin);
		
		label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setBounds(250, 29, 54, 15);
		panel.add(label_1);
		
		textUser = new JTextField();
		textUser.setBounds(293, 26, 66, 21);
		panel.add(textUser);
		textUser.setColumns(10);
		
		itemUsers=new DefaultListModel<String>();
	}

	private class BtnLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//登录
			String IP=textIP.getText().trim(); 
			int port=Integer.parseInt(textPort.getText().trim());	
			String user=textUser.getText().trim();
			try {
				Socket client=new Socket(IP,port);
				ChatRunable chRunable=new ChatRunable(user,client);
				EventQueue.invokeLater(chRunable);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		         
		}
	}

}
