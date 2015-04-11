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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������Ĭ���˳�����Ϊ�ر�
		status.getWindows().put("MenuWindow", this);

		setTitle("�������ϵͳ");
		setResizable(true);
		

		// �����û����棬��Ӽ��������ز�ͬ����ģ��
		// ��ͬģ��ֱ��ȡ����¼����ⵥ��¼�����ⵥ��¼����
		// (�������紫����߱����ļ���д)
		welcome = new JLabel("sorry������û�е�¼Ŷ-_-||");
		welcome.setFont(StaticValue.DEFAULT_FONT);
		welcome.setBounds(10, 10, 853, 44);
		getContentPane().add(welcome);

		list = new JList<ItemFromJList>();
		list.addMouseMotionListener(new MouseMotionAdapter() {
			// ������Ŀ�Ŵ�Ķ���Ч��
			@Override
			public void mouseMoved(MouseEvent e) {
				currentindex = list.locationToIndex(e.getPoint());
				// ע�����ڷ��͵�ʹ�ã�����Ҫת����ȡ��������
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
				// �ж��û�ѡ��Ĺ���

				switch (currentindex) {
				case 0:// �������Ϲ���
					if (isNotOpen("GoodsDataAdmin"))
						new GoodsDataAdmin();
					break;
				case 1:// ����������
					if (isNotOpen("IncomingRecordAdmin"))
						new IncomingRecordAdmin();
					break;
				case 2:// ����������
					if (isNotOpen("OutgoingRecordAdmin"))
						new OutgoingRecordAdmin();
					break;
				case 3:// �û�����
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
		list.setOpaque(false); // ͸����ʾ

		ItemFromJList item1 = new ItemFromJList("res/icon1.png", "�������Ϲ���");
		ItemFromJList item2 = new ItemFromJList("res/icon2.png", "����������");
		ItemFromJList item3 = new ItemFromJList("res/icon3.png", "����������");
		ItemFromJList item4 = new ItemFromJList("res/icon3.png", "�û���Ϣ����");

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
		welcome.setText("�񨌡��½�ɹ���" + status.getLoginUsername()
				+ ",��ӭ����ʹ��\\(^o^)/" + "������Ҫʹ�õĹ���");
		setup();// ��ʾ����
		// this.repaint();
		// Util.displayAtCenter(this);
	}
}
