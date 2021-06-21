/*游戏面板。
  Timer类和Random类的使用。
*/
package client;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Random;
import javax.swing.*;
 
public class GamePanel extends JPanel
              implements ActionListener,KeyListener,Runnable{
	private int life=10;//生命值的初始化
	private char keyChar;//按下的字母记录
	private JLabel lbMoveChar=new JLabel();//掉下来的字母Label
	private JLabel lbLife=new JLabel();//显示当前生命值的Label
	private Socket s=null;
	private Timer timer=new Timer(100,this);
	private Random rnd=new Random();
	private BufferedReader br=null;
	private PrintStream ps=null;
	private boolean canRun=true;
 
	public GamePanel() {
		
		/**将面板的格式置成空，由此之后将会对所有进行重新设置**/
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.setSize(240,320);
		
		/**设置显示生命值的标签的样式**/
		this.add(lbLife);
		lbLife.setFont(new Font("黑体",Font.BOLD,20));
		lbLife.setBackground(Color.YELLOW);
		lbLife.setForeground(Color.PINK);
		lbLife.setBounds(0,0,this.getWidth(),20);//设置了标签的大小
		
		/**设置掉下来的标签**/
		this.add(lbMoveChar);
		lbMoveChar.setFont(new Font("黑体",Font.BOLD,20));
		lbMoveChar.setForeground(Color.YELLOW);
		this.init();
		this.addKeyListener(this);
		
		try {
			s=new Socket("127.0.0.1",9999);
		    JOptionPane.showMessageDialog(this, "连接成功");
		    InputStream is=s.getInputStream();
		    br=new BufferedReader(new InputStreamReader(is));
		    OutputStream os=s.getOutputStream();
		    ps=new PrintStream(os);
		    new Thread(this).start();
		    
		}catch (Exception ex) {
			javax.swing.JOptionPane.showMessageDialog(this, "游戏退出异常！");
			System.exit(0);
		}
		timer.start();
	}
	
	//实现掉落的字母起始位置的随机
	public void init() {
		lbLife.setText("当生命值为："+life);
		String str=String.valueOf((char)('A'+rnd.nextInt(26)));
		lbMoveChar.setText(str);
		lbMoveChar.setBounds(rnd.nextInt(this.getWidth()),0, 20, 20);//起始位置是横坐标随机，纵坐标从0，组件大小为20,20
	}
	
	public void run() {
		try {
			while(canRun) {
				String str=br.readLine();
				int score=Integer.parseInt(str);
				life+=score;
				checkFail();
			}
		}catch(Exception ex) {
			canRun=false;
			javax.swing.JOptionPane.showMessageDialog(this, "游戏退出异常！");
			System.exit(0);
		}
	}
	
//Timer来控制移动字母的下落，每100ms则执行一次此操作
	public void actionPerformed(ActionEvent e) {
		if(lbMoveChar.getY()>=this.getHeight())	{
			life--;
			checkFail();
		}
		lbMoveChar.setLocation(lbMoveChar.getX(),lbMoveChar.getY()+10);//实现这个字母自己下坠
	}
	
	public void checkFail()//检验生命值是否小于0，如果小于0则退出游戏。
	{
		init();
		if(life<=0) {
			timer.stop();
			javax.swing.JOptionPane.showMessageDialog(this, "生命值耗尽，游戏失败！");
			System.exit(0);
		}
	}
	//键盘操作事件对应行为
	public void keyPressed(KeyEvent e) {
		keyChar=e.getKeyChar();//记录键盘输入值
		String keyStr=String.valueOf(keyChar).toUpperCase();//将此值转化成大写的字符
		try {
			if(keyStr.equals(lbMoveChar.getText())) {
				life+=2;
				ps.println("-1");
			}else {
				life--;
			}
			checkFail();
		}catch(Exception ex) {
			ex.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(this, "游戏异常退出！");
			System.exit(0);
		}	
	}
 
	public void keyReleased(KeyEvent arg0) {}
 
	public void keyTyped(KeyEvent arg0) {}
}