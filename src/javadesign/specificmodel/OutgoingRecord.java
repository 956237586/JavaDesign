package javadesign.specificmodel;

public class OutgoingRecord extends OperateRecord {
	private static final long serialVersionUID = 1L;

	public OutgoingRecord() {
	}

	public OutgoingRecord(String outgoingNo, String operator,
			int outgoingGoodId, int outgoingQuantity, String note) {
		super(outgoingNo, operator, outgoingGoodId, outgoingQuantity, note);
	}

}
