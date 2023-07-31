package view.gui;

import javax.swing.*;

import java.awt.*;

/**
 * Class for put images in a window using a label
 */
public class ImagePanel {

	/**
	 * Creates an image Icon with a JLabel height and width values
	 * 
	 * @param label     The JLabel that is going to receive the image Icon
	 * @param pathImage The path where the image is
	 * @return The Image icon with the defined scale
	 */
	public Icon paintComponent(JLabel label, String pathImage) {
		Icon image = null;
		try {

			image = new ImageIcon(new ImageIcon(getClass().getResource(pathImage))
					.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
							Image.SCALE_DEFAULT));

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return image;

	}

}
