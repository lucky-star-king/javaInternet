package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;

public class ChatFrame extends JFrame  {

	private JPanel contentPane;
	public JPanel panel;
	public JButton btnSend;
	public JButton button;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public JScrollPane scrollPane_2;
	public JTextArea textSend;
	public JLabel lblNewLabel;
	public JTextArea textArea;
	public JList list;
	public JButton btnNewButton;
	public JButton refresh;
	public  DefaultListModel<String> itemList;
	private SocketThread socketThread=null;
	public JProgressBar progressBar;
	public JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChatFrame frame = new ChatFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChatFrame(SocketThread socketThread) {
   this.socketThread=socketThread;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 449, 479, 98);
		contentPane.add(panel);
		
		btnSend = new JButton("发送");
		btnSend.addActionListener(new BtnSendActionListener());
		btnSend.setBackground(Color.LIGHT_GRAY);
		btnSend.setBounds(205, 65, 138, 23);
		panel.add(btnSend);
		
		button = new JButton("群发");
		button.addActionListener(new ButtonActionListener());
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(20, 65, 188, 23);
		panel.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 22, 333, 36);
		panel.add(scrollPane);
		
		textSend = new JTextArea();
		textSend.setLineWrap(true);
		textSend.setColumns(10);
		scrollPane.setViewportView(textSend);
		
		btnNewButton = new JButton("退出登录");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(341, 65, 117, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("文件传输");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(349, 24, 103, 34);
		panel.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBorder(new TitledBorder(null, "\u804A\u5929\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(10, 45, 320, 394);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(null, "\u5728\u7EBF\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_2.setBounds(340, 45, 150, 394);
		contentPane.add(scrollPane_2);
	 	itemList=new DefaultListModel<>();
		list = new JList();
		list.setModel(itemList);
		scrollPane_2.setViewportView(list);
		
		lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(28, 10, 174, 25);
		contentPane.add(lblNewLabel);
		
		refresh = new JButton("刷新用户列表");
		refresh.setBackground(Color.LIGHT_GRAY);
		refresh.addActionListener(new RefreshActionListener());
		refresh.setFont(new Font("宋体", Font.PLAIN, 12));
		refresh.setBounds(378, 22, 111, 25);
		contentPane.add(refresh);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 557, 479, 19);
		contentPane.add(progressBar);
	}
	//弹窗
	public int confimmess(String sendside) {
	return	JOptionPane.showConfirmDialog(this, sendside+"向你发送了文件，你确认接收吗？");
		
	}
	//刷新列表的方法
	public  void Refreashlist() {
		itemList.removeAllElements();
		for(String n:ClientMG.getClientMG().getArrayList()) {
			itemList.addElement(n);
		
		}
	}
	private class RefreshActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//刷新在线列表
		    Refreashlist();
		}
	}
	private class BtnSendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//发送
//			SocketThread close=null;
//			for (SocketThread n:ClientMG.getClientMG().getArrayList()) {
//				if(n.getname()==list.getSelectedValue()) {
//					close=n;
//					n.sendMe(n.getSocket());
//				}
//			}	
			if(list.getSelectedIndex()>=0) {
			String mess="MESS|"+textSend.getText().trim()+"|"+socketThread.getname()+"|"+list.getSelectedValue();
			socketThread.sendMe(mess);
			textArea.append("我:"+textSend.getText().trim()+"\n");
			}
		}
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String mess="EXIT|"+socketThread.getname();
			socketThread.sendMe(mess);
			socketThread.stop();
		}
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String mess="ALL|"+"[群发]"+textSend.getText().trim()+"|"+socketThread.getname()+"|"+"群发";
			socketThread.sendMe(mess);
		//	textArea.append("我【群发】:"+textSend.getText().trim()+"\n");
			
			
		}
	}
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(list.getSelectedIndex()>=0) {
				filesever fileser=new filesever(textSend.getText().trim(),9999);
				fileser.startfiletrans();
				File file=new File(textSend.getText().trim());
				String filename=file.getName();
				String filelen=String.valueOf(file.length())+"b";
				String mess="FILETRANS"+"|"+socketThread.getname()+"|"
				+list.getSelectedValue()+"|"+filename+"#"+filelen+"#"+fileser.getIP()+"#"+9999;
				socketThread.sendMe(mess);
				textArea.append("我发出了文件发送请求"+"->"+list.getSelectedValue());
				}
		}
	}
}
