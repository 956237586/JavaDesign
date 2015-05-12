package javadesign.windows;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javadesign.abstractmodel.MenuItem;
import javadesign.abstractmodel.Window;
import javadesign.specificmodel.IconListRenderer;
import javadesign.util.StaticValue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MenuWindow extends Window {
	private static final long serialVersionUID = 1L;
	private static final Font DEFAULT_LIST_FONT = StaticValue.DEFAULT_FONT;
	private JLabel welcome;
	private JList<MenuItem> list;
	private int currentindex;
	private MenuItem currentItem;

	public MenuWindow() {
		super("res/bg.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// if close this window, program will exit
		status.getWindows().put("MenuWindow", this);

		setTitle("货物管理系统");
		setResizable(true);

		// create window add listener to component
		welcome = new JLabel("sorry！您还没有登录哦-_-||");
		welcome.setFont(StaticValue.DEFAULT_FONT);
		welcome.setBounds(10, 10, 853, 44);
		getContentPane().add(welcome);

		list = new JList<MenuItem>();
		list.addMouseMotionListener(new MouseMotionAdapter() {
			// zoom the text when mouse move on the item
			@Override
			public void mouseMoved(MouseEvent e) {
				currentindex = list.locationToIndex(e.getPoint());
				currentItem = list.getModel().getElementAt(currentindex);
				currentItem.setMouseStatus(0);
				list.setSelectedIndex(currentindex);
				repaint();
			}
		});

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				currentItem.setMouseStatus(1);
				list.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				currentItem.setMouseStatus(0);
				list.repaint();
				// switch user's choice

				switch (currentindex) {
				case 0:// good data administration
					if (isNotOpen("GoodsDataAdmin"))
						new GoodsDataAdmin();
					break;
				case 1:// incoming record administration
					if (isNotOpen("IncomingRecordAdmin"))
						new IncomingRecordAdmin();
					break;
				case 2:// outgoing record administration
					if (isNotOpen("OutgoingRecordAdmin"))
						new OutgoingRecordAdmin();
					break;
				case 3:// exit program
					System.exit(0);
					break;
				default:
					break;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				currentItem.setMouseStatus(2);
				repaint();
			}
		});

		list.setFont(DEFAULT_LIST_FONT);
		list.setCellRenderer(new IconListRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<MenuItem> listModel = new DefaultListModel<MenuItem>();
		list.setModel(listModel);
		list.setOpaque(false); // set to transparent component

		MenuItem item1 = new MenuItem("res/icon1.png", "货物资料管理");
		MenuItem item2 = new MenuItem("res/icon2.png", "货物入库管理");
		MenuItem item3 = new MenuItem("res/icon3.png", "货物出库管理");
		MenuItem item4 = new MenuItem("res/icon4.png", "退出管理系统");

		listModel.addElement(item1);
		listModel.addElement(item2);
		listModel.addElement(item3);
		listModel.addElement(item4);

		list.setBounds(76, 135, 241, 406);
		getContentPane().add(list);

		new Login();
	}

	public boolean isNotOpen(String windowName) {
		Window tWindow = status.getWindow(windowName);
		boolean ret;
		if (tWindow == null) {
			ret = true;
		} else {
			ret = false;
			tWindow.setVisible(true);
			tWindow.requestFocus();
		}
		return ret;
	}

	public void LoginSucceed() {
		welcome.setText("  ●▽●登录成功，" + status.getLoginUsername()
				+ ",欢迎您的使用\\(^o^)/" + "请点击您要使用的功能");
		setup();// show window
	}
}
