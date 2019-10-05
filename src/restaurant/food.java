package restaurant;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class food extends JFrame implements ActionListener{
    JPanel contentPanel = null, imagePanel = null;
    JLabel wordLabel = null, bgLabel = null;
    ImageIcon background = null;
    
    JButton btn1=new JButton("餐廳選擇");
    JButton btn2=new JButton("建立你的小餐廳");
  	JLabel lab=new JLabel();
    
    public food(){
        
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
	  
	  	btn1.addActionListener(this);     // 把事件傾聽者frm向btn1註冊
        btn2.addActionListener(this);     // 把事件傾聽者frm向btn2註冊
     
		lab.setText("今天你要吃什麼?");
		lab.setForeground(Color.black);
		lab.setLocation(150,120);          // 設定標籤位置
		lab.setSize(1000,100);             // 設定標籤大小
		lab.setFont(new Font("微軟正黑體",Font.BOLD,90));
		this.add(lab);
		
		this.setTitle("Food");
		this.setLayout(null);
		btn1.setBounds(150,350,300,150);
		btn2.setBounds(550,350,300,150);
		btn1.setFont(new Font("微軟正黑體",Font.BOLD,35));
		btn2.setFont(new Font("微軟正黑體",Font.BOLD,35));
		this.setSize(1000,650);
		this.setLocation(300,150);
		
		this.add(btn1);
		this.add(btn2);
		this.setVisible(true);
        
	    // 於JFrame中設置背景圖片 - 圖片無法縮放大小
	    background = new ImageIcon("images/1.png");       // 背景圖片
	    bgLabel = new JLabel(background);      // 把背景圖顯示在Label中
	    bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    // 把含有背景圖之Label位置設置為圖片剛好填充整個版面
	    // 把內容視窗轉為JPanel，否則不能使用setOpaque()來使視窗變成透明
	    imagePanel = (JPanel) this.getContentPane();
	    imagePanel.setOpaque(false);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));     // 把背景圖添加到分層窗格的最底層以作為背景
        
    }
       	
   	public void actionPerformed(ActionEvent e){
  		JButton btn=(JButton) e.getSource();     // 取得事件來源的物件
  		if(btn==btn1){// 如果是按下btn1按鈕
     		this.setVisible(false); 
     		new eatWhat();
    	      
  		}                       
  		else if(btn==btn2) {// 如果是按下btn2按鈕
  			this.setVisible(false); 
     		new yourRestaurant();
  		}     
	}
    
    public static void main(String[] args){
        new food();
    }
}