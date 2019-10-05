package restaurant;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RestaurantPanel extends JPanel{
	
	Image  img = null ;
	String imagePath;
	
	RestaurantPanel(String imagePath){
		this.imagePath=imagePath;
	}
	@Override
	public void paintComponent (Graphics g){    
		
		try {
			 img = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    super.paintComponents(g);
	    g.drawImage(img, 0, 0, this);
	     
	}
	
}
