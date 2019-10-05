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
    
    JButton btn1=new JButton("�s�W");
    JButton btn2=new JButton("�R��");
    JButton btn3=new JButton("�ڪ��̷R");
    JButton btn4=new JButton("��^");
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
     
		lab1.setText("�A���p�\�U");
		lab1.setForeground(Color.black);
		lab2.setText("�s�W�榡:�\�U�W�� �ϰ� ���� �O�_���� �O�_���̷R(yes/no)");
		lab2.setForeground(Color.red);
		lab3.setText("�R���榡:�\�U�W��");
		lab3.setForeground(Color.red);
		lab4.setText("�̷R�榡:�\�U�W��");
		lab4.setForeground(Color.red);    
   
		lab1.setFont(new Font("�L�n������",Font.BOLD,80));
		lab2.setFont(new Font("�L�n������",Font.BOLD,30));
		lab3.setFont(new Font("�L�n������",Font.BOLD,30));
		lab4.setFont(new Font("�L�n������",Font.BOLD,30));

		btn1.setFont(new Font("�L�n������",Font.BOLD,35));
		btn2.setFont(new Font("�L�n������",Font.BOLD,35));
		btn3.setFont(new Font("�L�n������",Font.BOLD,35));
		btn4.setFont(new Font("�L�n������",Font.BOLD,35));
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
  		JButton btn=(JButton) e.getSource();     // ���o�ƥ�ӷ�������
  		if(btn==btn1){// �p�G�O���U"�s�W"���s
  			txa.insert("",0);
  			if(count==0)
  			{
  				data.read("data/list.txt");
  				count=1;
  			}
  			String str=txa.getText();
  			data.add(str);
  			data.write("data/list.txt");
  			txa.setText("�s�W���\������");
  		}                       
  		else if(btn==btn2) {// �p�G�O���U"�R��"���s
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
  			txa.setText("��Ƥw�R��!");  	
  		} 
  		else if(btn==btn3) {// �p�G�O���U"�ڪ��̷R"���s
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
  			txa.setText("�[�J�ڪ��̷R�o:3");
  			txa.insert("",0);
  		}
  		else if(btn==btn4) {// �p�G�O���U"��^"���s
  			this.setVisible(false); 
  	        new food();
  		}
	}
    
}