package GDIDemo;

import java.awt.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GDITest extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDITest frame = new GDITest();
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
	public GDITest() {
		setTitle("\u7ED8\u5236\u56FE\u5F62");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(26, 28, 431, 329);
		contentPane.add(panel);
		
		btnNewButton = new JButton("\u7ED8\u5236\u56FE\u5F62");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(26, 367, 107, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u7ED8\u5236\u56FE\u7247");
		btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
		btnNewButton_1.setBounds(143, 367, 114, 40);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\u6E05\u9664");
		btnNewButton_2.addActionListener(new BtnNewButton_2ActionListener());
		btnNewButton_2.setBounds(267, 367, 124, 40);
		contentPane.add(btnNewButton_2);
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
//			绘制图形
//			1、获取可绘图的对象
			Graphics g = panel.getGraphics();  
			g.setColor(Color.RED);   //设置颜色
			g.drawLine(20, 50, 100, 300);
			g.drawRect(100, 100, 300, 200);
			g.drawString("Hello", 200, 200);
			g.fillRect(150, 150, 300, 200);						
		}
	}
	private class BtnNewButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
//			清除绘制内容
			panel.repaint();
		}
	}
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Image imgBoard = new ImageIcon("imgs\\ChessBoard.jpg").getImage();
			Image imgB = new ImageIcon("imgs\\black.png").getImage();
			Image imgW = new ImageIcon("imgs\\white.png").getImage();			
			Graphics g = panel.getGraphics(); 
			g.drawImage(imgBoard, 0,0,null);
			g.drawImage(imgB, 10,10,null);
			g.drawImage(imgW, 50,20,null);
		}
	}
}
