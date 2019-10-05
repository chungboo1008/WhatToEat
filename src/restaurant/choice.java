package restaurant;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;



public class choice extends JFrame implements ActionListener,ItemListener{
	static ArrayList<Store> Data = new ArrayList<Store>();
	static int count=0;
	
    JPanel contentPanel = null, imagePanel = null;
    JLabel wordLabel = null, bgLabel = null;
    ImageIcon background = null;
	
	JLabel lab1=new JLabel();
	JLabel lab2=new JLabel();
	JLabel lab3=new JLabel();
	JLabel lab4=new JLabel();
	JLabel lab5=new JLabel();
	static Checkbox ckb1=new Checkbox("A");
	static Checkbox ckb2=new Checkbox("B");
	static Checkbox ckb3=new Checkbox("100以下");
	static Checkbox ckb4=new Checkbox("100~200");
	static Checkbox ckb5=new Checkbox("200以上");
	static Checkbox ckb6=new Checkbox("是");
	static Checkbox ckb7=new Checkbox("否");
	static Checkbox ckb8=new Checkbox("是");
	static Checkbox ckb9=new Checkbox("否");
	
	static Button btn1=new Button("PUSH!");
	static Button btn2=new Button("返回");
	
	public choice(){
		
		btn1.addActionListener(this); 
		btn2.addActionListener(this); 
		
		ckb1.addItemListener(this);
		ckb2.addItemListener(this);
		ckb3.addItemListener(this);
		ckb4.addItemListener(this);
		ckb5.addItemListener(this);
		ckb6.addItemListener(this);
		ckb7.addItemListener(this);
		ckb8.addItemListener(this);
		
		lab1.setText("地區:");
		lab2.setText("價位:");
		lab3.setText("素食:");
		lab4.setText("最愛:");
		lab5.setText("");
		
		ckb1.setBackground(Color.white);
		ckb2.setBackground(Color.white);
		ckb3.setBackground(Color.white);
		ckb4.setBackground(Color.white);
		ckb5.setBackground(Color.white);
		ckb6.setBackground(Color.white);
		ckb7.setBackground(Color.white);
		ckb8.setBackground(Color.white);
		ckb9.setBackground(Color.white);
		
		lab1.setLocation(100,60);
		lab2.setLocation(100,140);
		lab3.setLocation(100,220);
		lab4.setLocation(100,300);
		lab5.setLocation(100,380);
		
		lab1.setSize(100,40);
		lab2.setSize(100,40);
		lab3.setSize(100,40);
		lab4.setSize(100,40);
		lab5.setSize(700,40);
		
		Font fnt=new Font("微軟正黑體",Font.PLAIN,40);	
		lab1.setFont(fnt);
		lab2.setFont(fnt);
		lab3.setFont(fnt);
		lab4.setFont(fnt);
		lab5.setFont(fnt);
		ckb1.setFont(fnt);
		ckb2.setFont(fnt);
		ckb3.setFont(fnt);
		ckb4.setFont(fnt);
		ckb5.setFont(fnt);
		ckb6.setFont(fnt);
		ckb7.setFont(fnt);
		ckb8.setFont(fnt);
		ckb9.setFont(fnt);
		btn1.setFont(fnt);
		btn2.setFont(fnt);
		
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		this.add(lab4);
		this.add(lab5);
		
		CheckboxGroup grp1=new CheckboxGroup();
		CheckboxGroup grp2=new CheckboxGroup();
		CheckboxGroup grp3=new CheckboxGroup();
		CheckboxGroup grp4=new CheckboxGroup();
		ckb1.setBounds(200,60,120,40);
		ckb2.setBounds(400,60,120,40);
		ckb1.setCheckboxGroup(grp1);
		ckb2.setCheckboxGroup(grp1);
		
		ckb3.setBounds(200,140,200,40);
		ckb4.setBounds(400,140,200,40);
		ckb5.setBounds(600,140,200,40);
		ckb3.setCheckboxGroup(grp2);
		ckb4.setCheckboxGroup(grp2);
		ckb5.setCheckboxGroup(grp2);
		
		ckb6.setBounds(200,220,120,40);
		ckb7.setBounds(400,220,120,40);
		ckb6.setCheckboxGroup(grp3);
		ckb7.setCheckboxGroup(grp3);
		
		ckb8.setBounds(200,300,120,40);
		ckb9.setBounds(400,300,120,40);
		ckb8.setCheckboxGroup(grp4);
		ckb9.setCheckboxGroup(grp4);
		
		this.add(ckb1);
		this.add(ckb2);
		this.add(ckb3);
		this.add(ckb4);
		this.add(ckb5);
		this.add(ckb6);
		this.add(ckb7);
		this.add(ckb8);
		this.add(ckb9);
		
		this.setSize(1000,650);
		this.setLocation(300,150);
		this.setLayout(null);
        btn1.setBounds(200,450,250,100);
        btn2.setBounds(850,500,120,80);
        this.add(btn1);
        this.add(btn2);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
        
     // 於JFrame中設置背景圖片
	    background = new ImageIcon("images/3.png");   
	    bgLabel = new JLabel(background); 
	    bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
	    imagePanel = (JPanel) this.getContentPane();
	    imagePanel.setOpaque(false);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE)); 
	    data.copy("data/list.txt");
		data.write("data/buffer.txt");
  }
  
  	public void actionPerformed(ActionEvent e)
  	{
  		Button btn=(Button) e.getSource();     // 取得事件來源的物件
        if(btn==btn1){// 如果是按下"PUSH"按鈕
        	if(count==0)
        	{
        		data.read("data/buffer.txt");
        		count=1;
        	}
            data.Random("data/buffer.txt");
            data.write("data/random.txt");
            File file=new File("data/random.txt");
    	    try 
    	    {
    	    	String storeName,area,price,taste,favorite;
    		  	String buffer;
                FileInputStream inputStream =  new FileInputStream(file);
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                while((buffer=bufferedReader.readLine())!=null) 
                {
                	storeName=buffer.split("\\|")[0];
                	area=buffer.split("\\|")[1];
                	price=buffer.split("\\|")[2];
                	taste=buffer.split("\\|")[3];
                	favorite=buffer.split("\\|")[4];
                	lab5.setText(storeName + "　" + area + "　" + price + "　" + taste + "　" + favorite);		
                }   
                inputStream.close();        
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" );                
            }
            catch(IOException ex) 
    	    {
    	        System.out.println("Error reading file '"  );                  
            }
        }                       
        else if(btn==btn2) {// 如果是按下"返回"按鈕
        	this.setVisible(false); 
            new eatWhat();
        }
  	}
  	
    public void itemStateChanged(ItemEvent e)
    {    
       if(ckb1.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkArea("data/buffer.txt","A");
    	   data.write("data/buffer.txt");
       }
       else if(ckb2.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkArea("data/buffer.txt","B");
    	   data.write("data/buffer.txt");
       }
       if(ckb3.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkPrice("data/buffer.txt","1");
    	   data.write("data/buffer.txt");
       }
       else if(ckb4.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkPrice("data/buffer.txt","2");
    	   data.write("data/buffer.txt");
       }
       else if(ckb5.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkPrice("data/buffer.txt","3");
    	   data.write("data/buffer.txt");
       }
       
       if(ckb6.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkTaste("data/buffer.txt","yes");
    	   data.write("data/buffer.txt");
       }
       else if(ckb7.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkTaste("data/buffer.txt","no");
    	   data.write("data/buffer.txt");
       }
       
       if(ckb8.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkFavorite("data/buffer.txt","yes");
    	   data.write("data/buffer.txt");
       }
       else if(ckb9.getState()==true)
       {
    	   data.read("data/buffer.txt");
    	   data.checkFavorite("data/buffer.txt","no");
    	   data.write("data/buffer.txt");
       }
    }

}