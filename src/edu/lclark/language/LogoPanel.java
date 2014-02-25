package edu.lclark.language;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LogoPanel extends JPanel {
	private Image logo;
	private JPanel panel;

	public LogoPanel(String img) {
		this(new ImageIcon(img).getImage());

	}

	public LogoPanel(Image image) {
		logo = image;
		Dimension size = new Dimension(logo.getWidth(null), logo.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		//setLayout(null);
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(logo, 0, 0,null);
	}
}
