package GDIDemo;

import java.awt.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GDITest2 extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;

	int [][] chessData = new int [15][15];   //�������ӵ�����Դ
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDITest2 frame = new GDITest2();
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
	public GDITest2() {
		setTitle("\u7ED8\u5236\u56FE\u5F62");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new MyPanel(chessData);
		panel.addMouseListener(new PanelMouseListener());
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
		}
	}
	private class BtnNewButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
//			�����������
			for(int i=0;i<chessData.length;i++) {
				for(int j=0;j<chessData[0].length;j++) {
					chessData[i][j] = 0;
					
				}
			}
			panel.repaint();
		}
	}
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {			
			for(int i=0;i<chessData.length;i++) {
				for(int j=0;j<chessData[0].length;j++) {
					chessData[i][j] = 2;
				}
			}
			panel.repaint();
			
		}
	}
	
	int iH= 20;
	int iW =20;
	int iQW = 10;
	int iQH = 10;
	int chessType = 1; 
	private class PanelMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg) {
			int x = arg.getX(); 
			int y = arg.getY();
			int i = Math.round((x - iW)/20f);
			int j = Math.round((y - iH)/20f);
			if (x>=0 && i<15 && j>=0 && j<15) {
				if(chessData[i][j]==0) {  
					chessType= chessType==1? 2:1;
					chessData[i][j] = chessType;
					panel.repaint();
					
					if(isSuccess(i,j,chessType)) {
						JOptionPane.showMessageDialog(null, chessType==1?"黑子赢了":"白字赢了");
					}
				}				
				
			}
			
			
		}
	}
	private boolean isSuccess(int x,int y,int chessType) {
		
		int [][]GameData=chessData;
		
		int c1 = 0, c2 = 0;

		for (int j = x; j >= 0; j--) {
			if (GameData[j][y] == chessType)
				c1++;
			else
				break;
		}
		// 
		for (int j = x; j < 15; j++) {
			if (GameData[j][y] == chessType)
				c2++;
			else
				break;
		}
		if (c1 + c2 - 1 >= 5) {
			return true;
		}

		c1 = 0;
		c2 = 0;
		for (int j = y; j >= 0; j--) {
			if (GameData[x][j] == chessType)
				c1++;
			else
				break;
		}

		for (int j = y; j < 15; j++) {
			if (GameData[x][j] == chessType)
				c2++;
			else
				break;
		}
		if (c1 + c2 - 1 >= 5) {
			return true;
		}


		c1 = 0;
		c2 = 0;
		for (int j = x, k = y; (j >= 0) && (k >= 0); j--, k--) {
			if (GameData[j][k] == chessType)
				c1++;
			else
				break;
		}
		for (int j = x, k = y; (j < 15) && (k < 15); j++, k++) {
			if (GameData[j][k] == chessType)
				c2++;
			else
				break;
		}
		if (c1 + c2 - 1 >= 5) {
			return true;
		}

		c1 = 0;
		c2 = 0;
		for (int j = x, k = y; (j >= 0) && (k >= 0); j++, k--) {
			if (GameData[j][k] == chessType)
				c1++;
			else
				break;
		}

		for (int j = x, k = y; (j < 15) && (k < 15); j--, k++) {
			if (GameData[j][k] == chessType)
				c2++;
			else
				break;
		}
		if (c1 + c2 - 1 >= 5) {
			return true;
		}

		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
