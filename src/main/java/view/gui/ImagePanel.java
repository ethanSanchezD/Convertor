package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class ImagePanel{
	
	
	  public Icon paintComponent(JLabel label, String pathImage) { Icon image = new
	  ImageIcon(new ImageIcon(getClass().getResource(pathImage))
	  .getImage().getScaledInstance(label.getWidth(),label.getHeight(),
	  Image.SCALE_DEFAULT));
	  
	  return image;
	  
	  
	 }

}
