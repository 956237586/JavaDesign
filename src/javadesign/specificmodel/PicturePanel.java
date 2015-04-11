package javadesign.specificmodel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;
	private int imgWidth;
	private int imgHeight;

	public PicturePanel() {
	}

	public PicturePanel(String imgPath) {
		this();
		setImagePath(imgPath);

	}

	public int getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	public void setImagePath(String imgPath) {
		try {
			image = ImageIO.read(new FileInputStream(imgPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setImgWidth(image.getWidth(this));
		setImgHeight(image.getHeight(this));
	}

	@Override
	public void paintComponent(Graphics g) {
		int x = 0;
		int y = 0;
		if (null == image) {
			return;
		}
		g.drawImage(image, x, y, imgWidth, imgHeight, this);
	}
}
