package edu.lclark.language.gui;

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private int defaultWidth;
    private int defaultHeight;

    private Image image;

    public ImageComponent(String imageName, int defaultWidth, int defaultHeight) {
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;
        try {
            image = new ImageIcon(ClassLoader.getSystemResource("edu/lclark/language/resources/" + imageName)).getImage();
        } catch (Exception e) {
            System.out.println("error loading image: " + imageName);
            System.exit(0);
        }
    }

    public void paintComponent(Graphics g) {
        if (image == null)
            return;

        // draw the image in the upper-left corner
        g.drawImage(image, 0, 0, null);

    }

    public Dimension getPreferredSize() {
        return new Dimension(defaultWidth, defaultHeight);
    }

    public Image getImage() {
        return image;
    }
}
