package Server;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ServerForm extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JLabel label;
	public JTextField textPort;
	public JButton btnStart;
	public JButton btnEnd;
	public JScrollPane scrollPane;
	public JTextArea textLog;
public static serverListener sliListener=null;
	static ServerSocket Server = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							super.windowClosed(e);
							try {
								ServerMG.getSmg().setTextlog("服务器即将关闭！！！");
								for(Socket socket:ServerMG.getSmg().getSocketlist()) {
									SocketThread.SendSocketMess(socket, "CLOSE|服务器关闭！！");
								}
								for(Socket socket:ServerMG.getSmg().getSocketlist()) {
									try {
										socket.close();
									} catch (IOException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
								}
							    ServerMG.getSmg().getSocketlist().clear();
								sliListener.setflag();
								Server.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});;
				ServerMG.getSmg().setwin(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ServerForm() {
		setTitle("\u591A\u4EBA\u804A\u5929\u670D\u52A1\u5668");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u914D\u7F6E\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 444, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("\u7AEF\u53E3\uFF1A");
		label.setBounds(20, 34, 54, 15);
		panel.add(label);
		
		textPort = new JTextField();
		textPort.setText("8800");
		textPort.setBounds(60, 31, 66, 21);
		panel.add(textPort);
		textPort.setColumns(10);
		
		btnStart = new JButton("\u5F00\u542F\u670D\u52A1");
		btnStart.setBackground(Color.LIGHT_GRAY);
		btnStart.addActionListener(new BtnStartActionListener());
		btnStart.setBounds(175, 30, 93, 23);
		panel.add(btnStart);
		
		btnEnd = new JButton("\u5173\u95ED\u670D\u52A1");
		btnEnd.setBackground(Color.LIGHT_GRAY);
		btnEnd.addActionListener(new BtnEndActionListener());
		btnEnd.setBounds(278, 30, 93, 23);
		panel.add(btnEnd);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new TitledBorder(null, "\u6D88\u606F\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(0, 79, 444, 397);
		contentPane.add(scrollPane);
		
		textLog = new JTextArea();
		textLog.setEditable(false);
		textLog.setLineWrap(true);
		scrollPane.setViewportView(textLog);
	}
	
	private class BtnStartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		//开启服务
			try {
				 Server=new ServerSocket(Integer.parseInt(textPort.getText()));
				ServerMG.getSmg().setTextlog("服务器创建成功！！");
				   sliListener= new serverListener(Server);
				       sliListener.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private class BtnEndActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//关闭服务
			try {
				ServerMG.getSmg().setTextlog("服务器即将关闭！！！");
				for(Socket socket:ServerMG.getSmg().getSocketlist()) {
					SocketThread.SendSocketMess(socket, "CLOSE|服务器关闭！！");
				}
				for(Socket socket:ServerMG.getSmg().getSocketlist()) {
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    ServerMG.getSmg().getSocketlist().clear();
				sliListener.setflag();
				Server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
