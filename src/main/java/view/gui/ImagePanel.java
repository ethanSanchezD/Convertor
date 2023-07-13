package view.gui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel{
	
	public Icon paintComponent(JLabel label) {
		Icon image = new ImageIcon(new ImageIcon(getClass().getResource("/icons/sukuna-chibi.png"))
				.getImage().getScaledInstance(label.getWidth(),label.getHeight(), 0));
		
		return image;
		
		
	}


}
