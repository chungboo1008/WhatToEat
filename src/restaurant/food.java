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
    
    JButton btn1=new JButton("�\�U���");
    JButton btn2=new JButton("�إߧA���p�\�U");
  	JLabel lab=new JLabel();
    
    public food(){
        
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
	  
	  	btn1.addActionListener(this);     // ��ƥ��ť��frm�Vbtn1���U
        btn2.addActionListener(this);     // ��ƥ��ť��frm�Vbtn2���U
     
		lab.setText("���ѧA�n�Y����?");
		lab.setForeground(Color.black);
		lab.setLocation(150,120);          // �]�w���Ҧ�m
		lab.setSize(1000,100);             // �]�w���Ҥj�p
		lab.setFont(new Font("�L�n������",Font.BOLD,90));
		this.add(lab);
		
		this.setTitle("Food");
		this.setLayout(null);
		btn1.setBounds(150,350,300,150);
		btn2.setBounds(550,350,300,150);
		btn1.setFont(new Font("�L�n������",Font.BOLD,35));
		btn2.setFont(new Font("�L�n������",Font.BOLD,35));
		this.setSize(1000,650);
		this.setLocation(300,150);
		
		this.add(btn1);
		this.add(btn2);
		this.setVisible(true);
        
	    // ��JFrame���]�m�I���Ϥ� - �Ϥ��L�k�Y��j�p
	    background = new ImageIcon("images/1.png");       // �I���Ϥ�
	    bgLabel = new JLabel(background);      // ��I������ܦbLabel��
	    bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    // ��t���I���Ϥ�Label��m�]�m���Ϥ���n��R��Ӫ���
	    // �⤺�e�����ରJPanel�A�_�h����ϥ�setOpaque()�Өϵ����ܦ��z��
	    imagePanel = (JPanel) this.getContentPane();
	    imagePanel.setOpaque(false);
	    this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));     // ��I���ϲK�[����h���檺�̩��h�H�@���I��
        
    }
       	
   	public void actionPerformed(ActionEvent e){
  		JButton btn=(JButton) e.getSource();     // ���o�ƥ�ӷ�������
  		if(btn==btn1){// �p�G�O���Ubtn1���s
     		this.setVisible(false); 
     		new eatWhat();
    	      
  		}                       
  		else if(btn==btn2) {// �p�G�O���Ubtn2���s
  			this.setVisible(false); 
     		new yourRestaurant();
  		}     
	}
    
    public static void main(String[] args){
        new food();
    }
}