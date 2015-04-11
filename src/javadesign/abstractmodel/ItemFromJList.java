package javadesign.abstractmodel;

import javadesign.specificmodel.IconListRenderer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ItemFromJList {

	private String iconPath;
	private String text;
	private int mouseStatus;// 0悬停 1按下 2松开

	public ItemFromJList() {

	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ItemFromJList(String iconPath, String text) {
		this.iconPath = iconPath;
		this.text = text;
	}

	public int getMouseStatus() {
		return mouseStatus;
	}

	public void setMouseStatus(int mouseStatus) {
		this.mouseStatus = mouseStatus;
	}

	// */
	public static void main(String[] args) {
		JFrame j = new JFrame("123");
		// j.getContentPane().add(new ItemFromJList("res/bg.png","321321"));
		// j.getContentPane().add(new
		// ItemFromJList("res/icon2.png","111111121"));
		JList<ItemFromJList> list = new JList<ItemFromJList>();
		// list.setFont(DEFAULT_LIST_FONT);
		list.setCellRenderer(new IconListRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<ItemFromJList> listModel = new DefaultListModel<ItemFromJList>();
		list.setModel(listModel);
		list.setOpaque(false); // 透明显示

		ItemFromJList item1 = new ItemFromJList("res/icon1.png", "这是测试文字1");
		ItemFromJList item2 = new ItemFromJList("res/icon2.png", "这是测试文字2");
		ItemFromJList item3 = new ItemFromJList("res/icon3.png", "这是测试文字3");

		listModel.addElement(item1);
		listModel.addElement(item2);
		listModel.addElement(item3);

		list.setBounds(76, 135, 262, 335);
		j.add(list);
		j.setBounds(0, 0, 400, 400);
		j.setVisible(true);
	}
	// */
}
