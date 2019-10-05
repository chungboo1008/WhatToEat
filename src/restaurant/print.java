package restaurant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
public class print
{
	static Frame frm=new Frame("顯示符合項目之餐廳");
	static TextArea txa;

	public print()
	{
		frm=new Frame("顯示符合項目之餐廳");
	
		frm.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
		txa=new TextArea("",8,14,TextArea.SCROLLBARS_NONE);
		frm.setLayout(null);             // 不使用版面配置
		txa.setBounds(50,100,400,500);        // 設定文字區的大小
		frm.setSize(500,650);
		frm.setLocation(1300,150);
		frm.add(txa);
		frm.setVisible(true);
		txa.setFont(txa.getFont().deriveFont(25f));
		}
}
