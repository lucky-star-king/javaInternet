

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class ipsearch extends JFrame {

	private JPanel contentPane;
	public JLabel top;
	public JLabel iptext;
	public JLabel localip;
	public JLabel nametext;
	public JLabel localname;
	public JLabel MACtext;
	public JLabel localMAC;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JTextField startIP;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_6;
	public JTextField endIp;
	public JButton btnNewButton;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JTable table;
	public JLabel lblNewLabel_5;
	public JProgressBar progressBar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ipsearch frame = new ipsearch();
					frame.setVisible(true);
					frame.setdefault();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public ipsearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		top = new JLabel("");
		top.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		top.setBounds(10, 10, 580, 81);
		contentPane.add(top);
		
		iptext = new JLabel("\u672C\u673AIP\uFF1A");
		iptext.setBounds(22, 20, 54, 15);
		contentPane.add(iptext);
		
		localip = new JLabel("");
		localip.setBounds(68, 20, 99, 15);
		contentPane.add(localip);
		
		nametext = new JLabel("\u672C\u673A\u540D\u79F0\uFF1A");
		nametext.setBounds(191, 20, 70, 15);
		contentPane.add(nametext);
		
		localname = new JLabel("");
		localname.setFont(new Font("宋体", Font.BOLD, 12));
		localname.setBounds(252, 20, 113, 15);
		contentPane.add(localname);
		
		MACtext = new JLabel("\u672C\u673AMAC\u5730\u5740\uFF1A");
		MACtext.setBounds(369, 20, 90, 15);
		contentPane.add(MACtext);
		
		localMAC = new JLabel("");
		localMAC.setBounds(457, 20, 120, 15);
		contentPane.add(localMAC);
		
		lblNewLabel = new JLabel("\u626B\u63CF\u5F00\u59CBIP");
		lblNewLabel.setBounds(22, 65, 70, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 10));
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_1.setBounds(88, 65, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(".");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(158, 65, 18, 15);
		contentPane.add(lblNewLabel_2);
		
		startIP = new JTextField();
		startIP.setBounds(168, 65, 27, 15);
		contentPane.add(startIP);
		startIP.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u626B\u63CF\u7EC8\u6B62IP");
		lblNewLabel_3.setBounds(227, 65, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 10));
		lblNewLabel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_4.setBounds(293, 65, 78, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel(".");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(375, 65, 18, 15);
		contentPane.add(lblNewLabel_6);
		
		endIp = new JTextField();
		endIp.setBounds(386, 65, 27, 15);
		contentPane.add(endIp);
		endIp.setColumns(10);
		
		btnNewButton = new JButton("\u9AD8\u901F\u626B\u63CF");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(484, 61, 93, 23);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(0, 101, 600, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 580, 328);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IP", "\u673A\u5668\u540D", "\u53EF\u63A5\u901A"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNewLabel_5 = new JLabel("\u6B63\u5728\u626B\u63CF...");
		lblNewLabel_5.setBounds(6, 459, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(88, 459, 502, 15);
		contentPane.add(progressBar);
	}
	private class BtnNewButtonActionListener implements ActionListener {    //点击事件
		
		public void actionPerformed(ActionEvent e) {
			if(startIP.getText().length()==0||endIp.getText().length()==0) {
				JOptionPane.showMessageDialog(null,"请输入开始和结束IP");
				return;
			}
		      int ippstart=Integer.parseInt(startIP.getText());
		      int ippend=Integer.parseInt(endIp.getText());
		      if(ippstart<0||ippstart>255||ippend<0||ippend>255) {
		  		startIP.setText("");
		  		endIp.setText("");
				JOptionPane.showMessageDialog(null,"输入数字非法！！！请重新输入");
			}else {
				
			for(int i=ippstart;i<=ippend;i++){
				
				new Thread(new serachip(i,((i-ippstart)/(ippend-ippstart))*100)).start();  //开扫描线程 添加表单元素
			}
			}
		      return;
		}
	}
	
	public  void setdefault() throws SocketException {   //设置默认参数
		try {
			InetAddress inetAddress1=InetAddress.getLocalHost();
			localip.setText(inetAddress1.getHostAddress());;	
			localname.setText(inetAddress1.getHostName());
			NetworkInterface networkInterface=NetworkInterface.getByInetAddress(inetAddress1);
		 byte[]a =networkInterface.getHardwareAddress();
		 String m="";
		 for(byte x:a) {
				m+=Integer.toHexString((int)x&255)+"-";
			 }
			 m=m.substring(0, m.length()-1);
			localMAC.setText(m);
			String ipbegin="";
//		 System.out.print(inetAddress1.getHostAddress());
		 byte[] ipp= inetAddress1.getAddress();
				 for(int x=0;x<3;x++) {
						ipbegin+=((int)ipp[x]&255)+".";
					 }
                ipbegin=ipbegin.substring(0,ipbegin.length()-1);
		    lblNewLabel_1.setText(ipbegin);
		    lblNewLabel_4.setText(ipbegin);
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private class serachip implements Runnable{
//		String ipmax;
    public int iptest;
	public int value;
          public serachip(int iptest,int value) {
			// TODO Auto-generated constructor stub
        	  this.iptest=iptest;
        	  this.value=value;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String ippstart=lblNewLabel_1.getText()+"."+iptest;
			try {
				Thread thread= new Thread(new setbar(value));  
				thread.start();
				thread.join();//开进度条线程
				InetAddress inetAddress=InetAddress.getByName(ippstart);
				
				String hostname="   ——————————";
				
				DefaultTableModel items=(DefaultTableModel)table.getModel();
				
				String reachable="×";
				if(inetAddress.isReachable(200)) {
					reachable="√";
					hostname=inetAddress.getHostName();
					}
				String [] sRow= {ippstart,hostname,reachable};
//				items.addRow(sRow);
			settable(items, sRow);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			
		}
		
		
		
	}
	public synchronized void settable(DefaultTableModel items,String [] sRow) {
		items.addRow(sRow);
	}
	public synchronized void setprocess(int value) {  //进度条锁
		progressBar.setValue(value);
	}
	public class setbar implements Runnable{     //进度条线程
     int value;
public setbar( int value) {
	// TODO Auto-generated constructor stub
	this.value=value;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		setprocess(value);
	}
	}
}
