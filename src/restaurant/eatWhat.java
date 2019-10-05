package restaurant;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class eatWhat extends JFrame implements ActionListener{
	JPanel contentPanel = null, imagePanel = null;
	JLabel wordLabel = null, bgLabel = null;
	ImageIcon background = null;
	JButton btn1=new JButton("幫我挑一個");
	JButton btn2=new JButton("列出所有餐廳");
	JButton btn3=new JButton("返回");
	JLabel lab=new JLabel();
   
   public eatWhat(){
      this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
	   
	  btn1.addActionListener(this);     // 把事件傾聽者frm向btn1註冊
      btn2.addActionListener(this);     // 把事件傾聽者frm向btn2註冊
      btn3.addActionListener(this);     
     
      lab.setText("吃什麼?");
      //lab.setBackground(Color.white);
      //lab.setAlignment(Label.CENTER);
      lab.setForeground(Color.black);
      lab.setLocation(350,100);          // 設定標籤位置
      lab.setSize(1000,150);             // 設定標籤大小
      lab.setFont(new Font("微軟正黑體",Font.BOLD,100));
      this.add(lab);
      
      this.setTitle("Food");
      this.setLayout(null);
      btn1.setBounds(150,300,300,150);
      btn2.setBounds(550,300,300,150);
      btn3.setBounds(850,500,120,80);
      btn1.setFont(new Font("微軟正黑體",Font.BOLD,35));
      btn2.setFont(new Font("微軟正黑體",Font.BOLD,35));
      btn3.setFont(new Font("微軟正黑體",Font.BOLD,35));
      this.setSize(1000,650);
      this.setLocation(300,150);
      this.add(btn1);
      this.add(btn2);
      this.add(btn3);
      this.setVisible(true);
      
      
	// 於JFrame中設置背景圖片
	background = new ImageIcon("images/2.png");   
	bgLabel = new JLabel(background);  
	bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
	imagePanel = (JPanel) this.getContentPane();
	imagePanel.setOpaque(false);
	this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE)); 
      
   }

   public void actionPerformed(ActionEvent e){
      JButton btn=(JButton) e.getSource();     // 取得事件來源的物件
      if(btn==btn1){	// 如果是按下"幫我挑一個"按鈕
         this.setVisible(false); 
         new choice();
      }                       
      else if(btn==btn2) {	// 如果是按下"列出所有餐廳"按鈕
    	  this.setVisible(false); 
          new search();
      }
      else if(btn==btn3) {	// 如果是按下"返回"按鈕
    	  this.setVisible(false); 
	      new food();
      }
      
        
   }
   
}
