package javadesign.windows;

import javadesign.abstractmodel.ItemFromJList;
import javadesign.abstractmodel.Window;
import javadesign.specificmodel.IconListRenderer;
import javadesign.util.StaticValue;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MenuWindow extends Window {
	private static final long serialVersionUID = 1L;
	private static final Font DEFAULT_LIST_FONT = StaticValue.DEFAULT_FONT;
	private JLabel welcome;
	private JList<ItemFromJList> list;
	private int currentindex;
	private ItemFromJList currentItem;


	public MenuWindow() {
		super("res/bg.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 主窗口默认退出操作为关闭
		status.getWindows().put("MenuWindow", this);

		setTitle("货物管理系统");
		setResizable(true);
		

		// 加载用户界面，添加监听器加载不同界面模块
		// 不同模块分别读取库存记录、入库单记录、出库单记录数据
		// (可以网络传输或者本地文件读写)
		welcome = new JLabel("sorry！您还没有登录哦-_-||");
		welcome.setFont(StaticValue.DEFAULT_FONT);
		welcome.setBounds(10, 10, 853, 44);
		getContentPane().add(welcome);

		list = new JList<ItemFromJList>();
		list.addMouseMotionListener(new MouseMotionAdapter() {
			// 增加条目放大的动画效果
			@Override
			public void mouseMoved(MouseEvent e) {
				currentindex = list.locationToIndex(e.getPoint());
				// 注：由于泛型的使用，不必要转换获取到的类型
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
				// 判断用户选择的功能

				switch (currentindex) {
				case 0:// 货物资料管理
					if (isNotOpen("GoodsDataAdmin"))
						new GoodsDataAdmin();
					break;
				case 1:// 货物入库管理
					if (isNotOpen("IncomingRecordAdmin"))
						new IncomingRecordAdmin();
					break;
				case 2:// 货物出库管理
					if (isNotOpen("OutgoingRecordAdmin"))
						new OutgoingRecordAdmin();
					break;
				case 3:// 用户管理
					System.out.println(3);
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
		DefaultListModel<ItemFromJList> listModel = new DefaultListModel<ItemFromJList>();
		list.setModel(listModel);
		list.setOpaque(false); // 透明显示

		ItemFromJList item1 = new ItemFromJList("res/icon1.png", "货物资料管理");
		ItemFromJList item2 = new ItemFromJList("res/icon2.png", "货物入库管理");
		ItemFromJList item3 = new ItemFromJList("res/icon3.png", "货物出库管理");
		ItemFromJList item4 = new ItemFromJList("res/icon3.png", "用户信息管理");

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
		welcome.setText("●▽●登陆成功，" + status.getLoginUsername()
				+ ",欢迎您的使用\\(^o^)/" + "请点击您要使用的功能");
		setup();// 显示窗口
		// this.repaint();
		// Util.displayAtCenter(this);
	}
}
