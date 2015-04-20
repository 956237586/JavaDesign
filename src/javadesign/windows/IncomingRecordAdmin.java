package javadesign.windows;

import java.util.Date;

import javadesign.specificmodel.Good;
import javadesign.specificmodel.IncomingRecord;
import javadesign.specificmodel.IncomingRecordData;
import javadesign.specificmodel.OperateWindow;
import javadesign.util.Util;

public class IncomingRecordAdmin extends OperateWindow {
	private static final long serialVersionUID = 1L;

	public IncomingRecordAdmin() {
		super();
		status.getWindows().put("IncomingRecordAdmin", this);
		setTitle("货物入库管理");
		
	}

	@Override
	public void loadData() {
		data = new IncomingRecordData();
		table.setModel(data);
		super.loadData();
	}

	@Override
	public void addItem(String[] properties) {
		int id = Integer.parseInt(properties[0]);
		Good tGood = (Good) goodsData.getItemByKey(id);
		if (tGood != null) {
			int quantity = Integer.parseInt(properties[1]);
			String note = properties[2];
			String incomingNo = "IN" + formatter.format(new Date());
			String operator = status.getLoginUsername();
			tGood.setQuantity(tGood.getQuantity() + quantity);
			data.addRow(new IncomingRecord(incomingNo, operator, id, quantity,
					note));
			super.addItem(properties);
		} else {
			Util.alertError("该种货物不存在，查证后重试！");
			showAddWindow();
		}
	}
}
