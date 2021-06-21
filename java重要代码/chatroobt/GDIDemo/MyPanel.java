package GDIDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	Image imgBoard = new ImageIcon("src\\imgs\\ChessBoard.jpg").getImage();
	Image imgB = new ImageIcon("src\\imgs\\black.png").getImage();
	Image imgW = new ImageIcon("src\\imgs\\white.png").getImage();	
	int [][] chessData; 
	int iH= 20;
	int iW =20;
	int iQW = 10;
	int iQH = 10;
	
	public MyPanel() {
	}
	public MyPanel(int [][] c) {
		chessData = c;
	}
	@Override
	public void paint(Graphics g) {
 		super.paint(g);
		g.drawImage(imgBoard, 0,0,null);		
		for(int i=0;i<chessData.length;i++) {
			for(int j=0;j<chessData[0].length;j++) {
				int x = i*20 +iW -iQW;
				int y = j*20 +iH -iQH;
				if(chessData[i][j] == 1) {
					g.drawImage(imgB, x, y ,null);
				}
				else if(chessData[i][j] == 2) {
					g.drawImage(imgW, x,y,null);
				}
			}
		}		
		
	}
}
