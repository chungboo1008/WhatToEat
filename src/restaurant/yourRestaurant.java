package restaurant;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class yourRestaurant extends JFrame implements ActionListener{
	
	static ArrayList<String> Data = new ArrayList<String>();
	static int count=0;
	
	RestaurantPanel contentPanel = null, imagePanel = null;
    JLabel wordLabel = null, bgLabel = null;
    ImageIcon background = null;
    
    JButton btn1=new JButton("新增");
    JButton btn2=new JButton("刪除");
    JButton btn3=new JButton("我的最愛");
    JButton btn4=new JButton("返回");
  	JLabel lab1=new JLabel();
  	JLabel lab2=new JLabel();
  	JLabel lab3=new JLabel();
  	JLabel lab4=new JLabel();
  	
  	public JTextArea txa;
    
    public yourRestaurant(){
        
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
	  
        contentPanel=new RestaurantPanel("images/4.png");
        txa=new JTextArea(5,10);
        txa.setLocation(100,150);
        txa.setBackground(Color.white);
        txa.setFont(txa.getFont().deriveFont(40f));
	  	
        btn1.addActionListener(this);    
        btn2.addActionListener(this);  
        btn3.addActionListener(this);
        btn4.addActionListener(this);
     
		lab1.setText("你的小餐廳");
		lab1.setForeground(Color.black);
		lab2.setText("新增格式:餐廳名稱 區域 價位 是否為素 是否為最愛(yes/no)");
		lab2.setForeground(Color.red);
		lab3.setText("刪除格式:餐廳名稱");
		lab3.setForeground(Color.red);
		lab4.setText("最愛格式:餐廳名稱");
		lab4.setForeground(Color.red);    
   
		lab1.setFont(new Font("微軟正黑體",Font.BOLD,80));
		lab2.setFont(new Font("微軟正黑體",Font.BOLD,30));
		lab3.setFont(new Font("微軟正黑體",Font.BOLD,30));
		lab4.setFont(new Font("微軟正黑體",Font.BOLD,30));

		btn1.setFont(new Font("微軟正黑體",Font.BOLD,35));
		btn2.setFont(new Font("微軟正黑體",Font.BOLD,35));
		btn3.setFont(new Font("微軟正黑體",Font.BOLD,35));
		btn4.setFont(new Font("微軟正黑體",Font.BOLD,35));
		this.setTitle("Food");
		this.setSize(1000,680);
		this.setLocation(300,150);
		
		GroupLayout groupLayout=new GroupLayout(contentPanel);
		contentPanel.setLayout(groupLayout);
		
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGap(100)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(lab1,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(lab2,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(lab3,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(lab4,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txa,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btn1,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addComponent(btn4,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						)));

				/*.addGroup(groupLayout.createParallelGroup()
						.addComponent(btn1,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(btn2,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(btn3,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(btn4,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)));*/
						
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGap(50)
				.addComponent(lab1,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addComponent(lab2,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addComponent(lab3,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addComponent(lab4,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(txa,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(btn1,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btn2,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btn3,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btn4,0,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
								)
						)
				.addGap(50)
				);
		
		contentPanel.add(lab1);
		contentPanel.add(lab2);
		contentPanel.add(lab3);
		contentPanel.add(lab4);
		contentPanel.add(btn1);
		contentPanel.add(btn2);
		contentPanel.add(btn3);
		contentPanel.add(btn4);
		contentPanel.add(txa);
		this.add(contentPanel);
		this.setVisible(true);
       
    }
       	
   	public void actionPerformed(ActionEvent e){
  		JButton btn=(JButton) e.getSource();     // 取得事件來源的物件
  		if(btn==btn1){// 如果是按下"新增"按鈕
  			txa.insert("",0);
  			if(count==0)
  			{
  				data.read("data/list.txt");
  				count=1;
  			}
  			String str=txa.getText();
  			data.add(str);
  			data.write("data/list.txt");
  			txa.setText("新增成功ˊˇˋ");
  		}                       
  		else if(btn==btn2) {// 如果是按下"刪除"按鈕
  			txa.insert("",0);
  			if(count==0)
  			{
  				data.read("data/list.txt");
  				count=1;
  			}
  			String str=txa.getText();
  			data.delete_and_favorite("data/list.txt",str,1);
  			data.write("data/list.txt");
  			txa.setText("");
  			txa.setText("資料已刪除!");  	
  		} 
  		else if(btn==btn3) {// 如果是按下"我的最愛"按鈕
  			txa.insert("",0);
  			if(count==0)
  			{
  				data.read("data/list.txt");
  				count=1;
  			}
  			String str=txa.getText();
  			data.delete_and_favorite("data/list.txt",str,2);
  			data.write("data/list.txt");
  			txa.setText("");
  			txa.setText("加入我的最愛囉:3");
  			txa.insert("",0);
  		}
  		else if(btn==btn4) {// 如果是按下"返回"按鈕
  			this.setVisible(false); 
  	        new food();
  		}
	}
    
}