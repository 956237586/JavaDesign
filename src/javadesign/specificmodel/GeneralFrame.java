package javadesign.specificmodel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javadesign.abstractmodel.Data;
import javadesign.abstractmodel.Window;
import javadesign.util.StaticValue;
import javadesign.util.Util;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GeneralFrame extends Window implements MouseListener,
		WindowListener {
	private static final long serialVersionUID = 1L;
	protected int btnNum;
	protected int currentItemIndex;
	protected Data data;
	protected JButton btnAdd;
	protected JButton btnDel;
	protected JButton btnSave;
	protected JButton btnRefresh;
	protected JTable table = new JTable();
	protected JScrollPane jScrollPane = new JScrollPane(table);
	protected HashMap<Integer, JButton> jButtons = new HashMap<Integer, JButton>();

	public GeneralFrame() {
		this(StaticValue.DEFAULT_BUTTON_NUM);
	}

	public GeneralFrame(int btnNum) {
		super("res/bg.png");
		this.btnNum = btnNum;
		// 设置自动适应的界面
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				jScrollPane.setSize(getWidth() - 30, getHeight() - 100);
			}
		});
		addWindowListener(this);

		getContentPane().setLayout(null);

		table.setOpaque(false);
		jScrollPane.setBounds(10, 58, 996, 668);
		getContentPane().add(jScrollPane);

		for (int i = 0; i < btnNum; i++) {
			JButton btnNewButton = new JButton("New button");
			jButtons.put(i, btnNewButton);
			btnNewButton.setFont(StaticValue.DEFAULT_FONT);
			btnNewButton.setBounds(10 + i * 108, 10, 98, 38);
			getContentPane().add(btnNewButton);
		}

		btnAdd = jButtons.get(0);
		btnDel = jButtons.get(1);
		btnSave = jButtons.get(2);
		btnRefresh = jButtons.get(3);

		btnAdd.setText("添加");
		btnDel.setText("删除");
		btnSave.setText("保存");
		btnRefresh.setText("刷新");

		for (int i = 0; i < 4; i++) {
			jButtons.get(i).addMouseListener(this);
		}

		table.setFont(StaticValue.DEFAULT_FONT);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	protected void delCurrentItem() {
		if (table.getRowCount() > 0) {
			currentItemIndex = table.getSelectedRow();
			if (currentItemIndex == -1) {
				currentItemIndex++;
			}
			data.removeRow(currentItemIndex);
		} else {
			Util.alertError("列表已经空了哦-_-。sorry！");
		}
	}

	public void addItem(String[] properties) {
		System.out.println("super add");
		reFresh();
		System.gc();
	}

	public void showAddWindow() {
	}

	public void loadData() {
		System.out.println("super load");
		data.loadData();
		setup();
	}

	public void reFresh() {
		System.out.println("reFresh reFresh");
		// table.revalidate();
		table.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if (clickedButton.equals(btnAdd)) {
			showAddWindow();
		} else if (clickedButton.equals(btnDel)) {
			delCurrentItem();
		} else if (clickedButton.equals(btnSave)) {
			data.saveData();
		} else if (clickedButton.equals(btnRefresh)) {
			reFresh();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		data.saveData();// 关闭时自动保存数据
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}
