import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class work0309 extends JFrame {

	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JTextField textField;
	public JLabel lblNewLabel_5;
	public JTextField textField_1;
	public JLabel lblNewLabel_6;
	public JTextField textField_2;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JScrollPane scrollPane;
	public JTextArea textArea;
	public JScrollPane scrollPane_1;
	public JTextField textField_3;
	public JButton btnNewButton_2;
	public JList<String> list;
    public	DefaultListModel<String> dlm = new DefaultListModel<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					work0309 frame = new work0309();
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
	public work0309() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hzh50\\Pictures\\精美壁纸\\8f4a94141e10dc6b621818819f0aff55.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 1009, 86);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0)), "\u914D\u7F6E", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 215, 0)));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 106, 556, 377);
		lblNewLabel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 250, 205), new Color(160, 160, 160)), "\u804A\u5929\u8BB0\u5F55", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 215, 0)));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(576, 106, 424, 377);
		lblNewLabel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 250, 205), new Color(160, 160, 160)), "\u5728\u7EBF\u7528\u6237", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 215, 0)));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 480, 1009, 75);
		lblNewLabel_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_3.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u53D1\u9001", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 215, 0)), "\u53D1\u9001", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 215, 0)));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("主机IP");
		lblNewLabel_4.setBounds(10, 24, 63, 62);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(66, 34, 147, 40);
		textField.setBorder(null);
		textField.setBackground(new Color(192, 192, 192));
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_5 = new JLabel("端口");
		lblNewLabel_5.setBounds(251, 34, 44, 44);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(294, 34, 132, 40);
		textField_1.setBorder(null);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setBackground(new Color(192, 192, 192));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_6 = new JLabel("用户名");
		lblNewLabel_6.setBounds(458, 34, 63, 40);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(523, 34, 110, 40);
		textField_2.setBorder(null);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setBackground(new Color(192, 192, 192));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(694, 31, 101, 43);
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setBounds(805, 31, 101, 43);
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 125, 527, 344);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBorder(null);
		scrollPane.setViewportView(textArea);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(587, 125, 403, 345);
		contentPane.add(scrollPane_1);
		
		list = new JList<String>();
		list.setToolTipText("");
		list.setFont(new Font("宋体", Font.PLAIN, 16));
		list.setBackground(UIManager.getColor("CheckBox.light"));
		scrollPane_1.setViewportView(list);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(211, 211, 211));
		textField_3.setBounds(42, 493, 763, 55);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_2 = new JButton("发送");
		btnNewButton_2.addActionListener(new BtnNewButton_2ActionListener());
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_2.setBorder(UIManager.getBorder("TextPane.border"));
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setBounds(842, 493, 119, 55);
		contentPane.add(btnNewButton_2);
	}
	public class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String data="主机IP-"+textField.getText()+":"+textField_1.getText()+"用户名-"+textField_2.getText();
//			DataModel datamodel= new DataModel();
//			String[] copys=new String[datamodel.values.length+1];
//					 for (String x:datamodel.values) {
//						 for ( String y:copys) {
//							 y=x;
//						 }
//					 }
//					 copys[copys.length-1]=data;
//			datamodel.values=copys;
//			
			dlm.addElement(data);
			list.setModel(dlm);
		}
	}
	private class BtnNewButton_1ActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dlm.clear();
			list.setModel(dlm);
		}
	}
	private class BtnNewButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( dlm.getSize()!=0) {
			textArea.append( dlm.lastElement()+" :"+textField_3.getText()+"\n");//默认选择最后登录的用户发消息
			}else {
				textArea.append("!!!----您还未登录----!!!");
			}
				
		}
	}
}
//class DataModel extends DefaultListModel<String>{
//	String[] values = new String[] {};
//	@Override
//	public int getSize() {
//		return values.length;
//	}
//	@Override
//	public String getElementAt(int index) {
//		return values[index];
//	}
//}
