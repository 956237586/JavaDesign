package javadesign.specificmodel;

import java.text.SimpleDateFormat;

import javadesign.util.StaticValue;
import javadesign.windows.AddWindow;

public class OperateWindow extends GeneralFrame {
	private static final long serialVersionUID = 1L;
	protected SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public OperateWindow() {
		loadData();
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
	}

	@Override
	public void showAddWindow() {
		System.out.println("add");
		String[] properties = new String[] {
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_ID],
				StaticValue.INCOMING_COLUMN_NAMES[StaticValue.INDEX_GOOD_QUANTITY + 2],
				StaticValue.GOODS_COLUMN_NAMES[StaticValue.INDEX_GOOD_NOTE], };
		new AddWindow(this, properties);
	}

}
