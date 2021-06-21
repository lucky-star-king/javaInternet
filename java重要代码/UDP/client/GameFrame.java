//客户端
package client;
import javax.swing.*;
 
public class GameFrame extends JFrame {
	private GamePanel gp;
	
	public GameFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String nickName=JOptionPane.showInputDialog("输入昵称");
		this.setTitle(nickName);
		gp=new GamePanel();
		this.add(gp);
		gp.setFocusable(true);
		this.setSize(gp.getWidth(), gp.getHeight());
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
 
}