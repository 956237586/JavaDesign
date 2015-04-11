package javadesign.abstractmodel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javadesign.logic.Status;

import javax.swing.JFrame;

import javadesign.specificmodel.GoodsData;
import javadesign.specificmodel.PicturePanel;
import javadesign.util.StaticValue;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static Status status = new Status();// 为保证status唯一所以写在这里
	protected static GoodsData goodsData = new GoodsData();
	protected PicturePanel bgPicture;

	public Window() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 所有窗口默认退出操作为隐藏
		setSize(StaticValue.DEFAULT_WIDTH, StaticValue.DEFAULT_HEIGHT);
		getContentPane().setLayout(null);
	}

	public Window(String imgPath) {
		this();
		// 设置自动缩放的背景
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
		setLocationRelativeTo(null);// 所有窗口默认启动位置为居中
		setVisible(true);
	}
}