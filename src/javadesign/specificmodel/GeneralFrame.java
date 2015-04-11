package javadesign.specificmodel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javadesign.abstractmodel.Data;
import javadesign.abstractmodel.Window;
import javadesign.util.StaticValue;
import javadesign.util.Util;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GeneralFrame extends Window implements MouseListener {
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
		// �����Զ���Ӧ�Ľ���
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				jScrollPane.setSize(getWidth() - 30, getHeight() - 100);
			}
		});

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

		btnAdd.setText("���");
		btnDel.setText("ɾ��");
		btnSave.setText("����");
		btnRefresh.setText("ˢ��");
		
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
			Util.alertError("�б��Ѿ�����Ŷ-_-��sorry��");
		}
	}

	public void addItem(String[] properties) {
		System.out.println("super add");
		reFresh();
		System.gc();
	}

	public void showAddWindow(){
	}
	
	public void loadData() {
		System.out.println("super load");
		setup();
	}

	public void reFresh() {
		System.out.println("reFresh reFresh");
		//table.revalidate();
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

}
