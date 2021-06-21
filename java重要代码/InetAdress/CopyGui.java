import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CopyGui extends JFrame {

	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JTextField textField;
	public JTextField textField_1;
	public JProgressBar progressBar;
	public JButton btnNewButton;
	public JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyGui frame = new CopyGui();
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
	public CopyGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("源文件路径：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setBounds(45, 31, 152, 35);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("目标文件路径：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1.setBounds(26, 104, 168, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(193, 31, 599, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 104, 610, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 295, 858, 22);
		contentPane.add(progressBar);
		
		btnNewButton = new JButton("开始复制");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 23));
		btnNewButton.setBounds(70, 201, 160, 52);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(286, 170, 506, 102);
		contentPane.add(lblNewLabel_2);
	}
	public class CopyFile implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 
			
			//textField.getText()
		}
		
	}
	
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
