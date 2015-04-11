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
	protected static Status status = new Status();// Ϊ��֤statusΨһ����д������
	protected static GoodsData goodsData = new GoodsData();
	protected PicturePanel bgPicture;

	public Window() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// ���д���Ĭ���˳�����Ϊ����
		setSize(StaticValue.DEFAULT_WIDTH, StaticValue.DEFAULT_HEIGHT);
		getContentPane().setLayout(null);
	}

	public Window(String imgPath) {
		this();
		// �����Զ����ŵı���
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
		setLocationRelativeTo(null);// ���д���Ĭ������λ��Ϊ����
		setVisible(true);
	}
}