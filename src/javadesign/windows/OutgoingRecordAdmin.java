package javadesign.windows;

import java.util.Date;

import javadesign.specificmodel.Good;
import javadesign.specificmodel.OperateWindow;
import javadesign.specificmodel.OutgoingRecord;
import javadesign.specificmodel.OutgoingRecordData;
import javadesign.util.Util;

public class OutgoingRecordAdmin extends OperateWindow {
	private static final long serialVersionUID = 1L;

	public OutgoingRecordAdmin() {
		super();
		status.getWindows().put("OutgoingRecordAdmin", this);
		setTitle("货物出库管理");
	}

	@Override
	public void loadData() {
		data = new OutgoingRecordData();
		table.setModel(data);
		super.loadData();
	}

	@Override
	public void addItem(String[] properties) {
		int id = Integer.parseInt(properties[0]);
		Good tGood = (Good) goodsData.getItemByKey(id);
		if (tGood != null) {
			int oldQuantity = tGood.getQuantity();
			int quantity = Integer.parseInt(properties[1]);
			if (oldQuantity > 0 && quantity <= oldQuantity) {
				String note = properties[2];
				String outGoingNo = "OUT" + formatter.format(new Date());
				String operator = status.getLoginUsername();
				tGood.setQuantity(tGood.getQuantity() - quantity);
				data.addRow(new OutgoingRecord(outGoingNo, operator, id,
						quantity, note));
				super.addItem(properties);
			} else {
				Util.alertError("该种货物库存不足，请进货后再出货！");
			}
		} else {
			Util.alertError("该种货物不存在，查证后重试！");
			showAddWindow();
		}
	}

}
