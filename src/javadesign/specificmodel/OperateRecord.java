package javadesign.specificmodel;

import javadesign.abstractmodel.ItemFromData;
import javadesign.abstractmodel.Window;

public class OperateRecord extends ItemFromData {

	private static final long serialVersionUID = 1L;
	private String operateNo;
	private String operator;
	private int operateGoodId;
	private int operateQuantity;

	public OperateRecord() {
	}

	public OperateRecord(String operateNo, String operator, int operateGoodId,
			int operateQuantity, String note) {
		setOperateNo(operateNo);
		setOperator(operator);
		//setOperateGoodId(operateGoodId);
		//setOperateQuantity(operateQuantity);
		Good tGood = (Good) Window.getGoodsData().getItemByKey(operateGoodId);
		String name = tGood.getName();
		String category = tGood.getCategory();
		double unitPrice = tGood.getUnitPrice();
		setOperateGood(new Good(operateGoodId, name, category, operateQuantity, unitPrice, note));
	}

	public String getOperateNo() {
		return operateNo;
	}

	public void setOperateNo(String operateNo) {
		this.operateNo = operateNo;
		add(operateNo);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
		add(operator);
	}

	public void setOperateGood(Good operateGood) {
		for (Object o : operateGood)
			add(o);
	}
	
	public int getOperateGoodId() {
		return operateGoodId;
	}

	public void setOperateGoodId(int operateGoodId) {
		this.operateGoodId = operateGoodId;
		add(operateGoodId);
	}

	public int getOperateQuantity() {
		return operateQuantity;
	}

	public void setOperateQuantity(int operateQuantity) {
		this.operateQuantity = operateQuantity;
		add(operateQuantity);
	}
}
