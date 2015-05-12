package javadesign.abstractmodel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.IOException;

import javadesign.logic.Status;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import javadesign.specificmodel.GoodsData;
import javadesign.specificmodel.PicturePanel;
import javadesign.util.StaticValue;

/**
 * This class is basic of windows in this program, all of window extends from
 * this class. When you add all component you need , just use setup(), an window
 * will be appear in center on the screen. Very simple!!
 * 
 * @author HYL
 *
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static Status status = new Status();// 为保证status唯一所以写在这里
	protected static GoodsData goodsData = new GoodsData();
	protected PicturePanel bgPicture;

	public Window() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 所有窗口默认退出操作为隐藏
		setSize(StaticValue.DEFAULT_WIDTH, StaticValue.DEFAULT_HEIGHT);
		getContentPane().setLayout(null);
		try {
			setIconImage(ImageIO.read(new FileInputStream("res/main.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * You can provide a image path as the background of window.
	 * 
	 * @param imgPath
	 */
	public Window(String imgPath) {
		this();
		// the background image will be zoom automatic
		bgPicture = new PicturePanel(imgPath);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				try {
					getContentPane().remove(bgPicture);
				} catch (Exception e) {
					e.printStackTrace();
				}
				bgPicture.setImgWidth(getWidth());
				bgPicture.setImgHeight(getHeight());
				bgPicture.setBounds(0, 0, getWidth(), getHeight());
				getContentPane().add(bgPicture, -1);
			}

		});
	}

	public static GoodsData getGoodsData() {
		return goodsData;
	}

	public void setup() {
		// all window appear in center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
}