package edu.lclark.language;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageComponent extends JComponent {
	private int defaultWidth;
	private int defaultHeight;

	private Image image;

	public ImageComponent(String imageName, int defaultWidth, int defaultHeight) {
		this.defaultWidth = defaultWidth;
		this.defaultHeight = defaultHeight;
		image = new ImageIcon(imageName).getImage();
	}

	public void paintComponent(Graphics g) {
		if (image == null)
			return;

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);

		// draw the image in the upper-left corner
		g.drawImage(image, 0, 0, null);

	}

	public Dimension getPreferredSize() {
		return new Dimension(defaultWidth, defaultHeight);
	}
}
