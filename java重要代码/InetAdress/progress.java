import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class progress extends JFrame {

	private JPanel contentPane;
	public JButton btnNewButton;
	public JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					progress frame = new progress();
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
	public progress() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("开始\r\n");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 35));
		btnNewButton.setBounds(220, 79, 305, 78);
		contentPane.add(btnNewButton);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 222, 742, 30);
		contentPane.add(progressBar);
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}
