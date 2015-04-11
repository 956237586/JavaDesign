package javadesign.specificmodel;

import javadesign.abstractmodel.Data;

public class OperateRecordData extends Data {
	private static final long serialVersionUID = 1L;
	public OperateRecordData(String[] columnNames) {
		super(columnNames);
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}
	

}
