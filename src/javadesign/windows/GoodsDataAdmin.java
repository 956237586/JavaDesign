package javadesign.windows;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javadesign.specificmodel.GeneralFrame;
import javadesign.specificmodel.Good;
import javadesign.util.StaticValue;
import javadesign.util.Util;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class GoodsDataAdmin extends GeneralFrame implements TableModelListener,
		WindowFocusListener {
	private static final long serialVersionUID = 1L;

	public GoodsDataAdmin() {
		super();
		status.getWindows().put("GoodsDataAdmin", this);
		setTitle("货物资料管理");
		addWindowFocusListener(this);
		loadData();
	}

	@Override
	public void loadData() {
		System.out.println("load");
		data = goodsData;
		table.setModel(data);
		data.addTableModelListener(this);
		super.loadData();
	}

	@Override
	public void showAddWindow() {
		System.out.println("add");
		String[] properties = new String[] {
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_ID],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_NAME],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_CATEGORY],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_QUANTITY],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_UNIT_PRICE],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_NOTE], };
		new AddWindow(this, properties);
	}

	@Override
	public void addItem(String[] properties) {
		int id = Integer.parseInt(properties[0]);
		if (goodsData.getItemByKey(id) == null) {
			String name = properties[1];
			String category = properties[2];
			int quantity = Integer.parseInt(properties[3]);
			double unitPrice = Double.parseDouble(properties[4]);
			String note = properties[5];
			data.addRow(new Good(id, name, category, quantity, unitPrice, note));
			super.addItem(properties);
		} else {
			Util.alertError("id重复，请重新输入");
		}
	}

	@Override
	public void tableChanged(TableModelEvent event) {
		if (event.getColumn() == StaticValue.INDEX_GOOD_QUANTITY
				|| event.getColumn() == StaticValue.INDEX_GOOD_UNIT_PRICE) {
			double stock = 0;
			double unitPrice = 0;// set unit price automatically
			try {
				stock = Double.parseDouble(""
						+ data.getValueAt(event.getFirstRow(),
								StaticValue.INDEX_GOOD_QUANTITY));
				unitPrice = Double.parseDouble(""
						+ data.getValueAt(event.getFirstRow(),
								StaticValue.INDEX_GOOD_UNIT_PRICE));
			} catch (NumberFormatException e) {
				Util.alertError("请检查输入值是否合法");
				e.printStackTrace();// check user input
			}
			double newTotalPrice = stock * unitPrice;
			data.setValueAt(newTotalPrice, event.getFirstRow(),
					StaticValue.INDEX_GOOD_TOTAL_PRICE);
		}
		data.saveData();
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		reFresh();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
	}
}
