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
	JButton btn1=new JButton("���ڬD�@��");
	JButton btn2=new JButton("�C�X�Ҧ��\�U");
	JButton btn3=new JButton("��^");
	JLabel lab=new JLabel();
   
   public eatWhat(){
      this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
	   
	  btn1.addActionListener(this);     // ��ƥ��ť��frm�Vbtn1���U
      btn2.addActionListener(this);     // ��ƥ��ť��frm�Vbtn2���U
      btn3.addActionListener(this);     
     
      lab.setText("�Y����?");
      //lab.setBackground(Color.white);
      //lab.setAlignment(Label.CENTER);
      lab.setForeground(Color.black);
      lab.setLocation(350,100);          // �]�w���Ҧ�m
      lab.setSize(1000,150);             // �]�w���Ҥj�p
      lab.setFont(new Font("�L�n������",Font.BOLD,100));
      this.add(lab);
      
      this.setTitle("Food");
      this.setLayout(null);
      btn1.setBounds(150,300,300,150);
      btn2.setBounds(550,300,300,150);
      btn3.setBounds(850,500,120,80);
      btn1.setFont(new Font("�L�n������",Font.BOLD,35));
      btn2.setFont(new Font("�L�n������",Font.BOLD,35));
      btn3.setFont(new Font("�L�n������",Font.BOLD,35));
      this.setSize(1000,650);
      this.setLocation(300,150);
      this.add(btn1);
      this.add(btn2);
      this.add(btn3);
      this.setVisible(true);
      
      
	// ��JFrame���]�m�I���Ϥ�
	background = new ImageIcon("images/2.png");   
	bgLabel = new JLabel(background);  
	bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight()); 
	imagePanel = (JPanel) this.getContentPane();
	imagePanel.setOpaque(false);
	this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE)); 
      
   }

   public void actionPerformed(ActionEvent e){
      JButton btn=(JButton) e.getSource();     // ���o�ƥ�ӷ�������
      if(btn==btn1){	// �p�G�O���U"���ڬD�@��"���s
         this.setVisible(false); 
         new choice();
      }                       
      else if(btn==btn2) {	// �p�G�O���U"�C�X�Ҧ��\�U"���s
    	  this.setVisible(false); 
          new search();
      }
      else if(btn==btn3) {	// �p�G�O���U"��^"���s
    	  this.setVisible(false); 
	      new food();
      }
      
        
   }
   
}
