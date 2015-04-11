package javadesign.specificmodel;

public class IncomingRecord extends OperateRecord {

	private static final long serialVersionUID = 1L;

	public IncomingRecord() {
	}

	public IncomingRecord(String incomingNo, String operator,
			int incomingGoodId, int incomingQuantity, String note) {
		super(incomingNo, operator, incomingGoodId, incomingQuantity, note);
	}
}
