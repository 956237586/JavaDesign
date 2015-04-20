package javadesign.specificmodel;

import java.io.File;

import javadesign.util.StaticValue;

public class IncomingRecordData extends OperateRecordData {
	private static final long serialVersionUID = 1L;
	public IncomingRecordData() {
		super(StaticValue.INCOMING_COLUMN_NAMES);
	}

	@Override
	public void loadData() {
		dataFile = new File(StaticValue.DATA_INCOMING);
		super.loadData();
		// 测试数据
		/*/
		for (int i = 0; i < 10; i++) {
			contents.add(new IncomingRecord(""+i,
					"hyl" + i,
					(int)(10 * Math.random()), 
					(int)(200 * Math.random()),
					"note " + i));
		}
		//*/
		/*
		 * contents.add(new IncomingRecord("1", "5555", 0, 50, "note 1"));
		 * contents.add(new IncomingRecord("2", "5555", 1, 100, "note135 1"));
		 * contents.add(new IncomingRecord("3", "5555", 2, 500, "n453ote 1"));
		 * contents.add(new IncomingRecord("4", "5555", 3, 20, "no453453te 1"));
		 * contents.add(new IncomingRecord("5", "5555", 0, 50, "note 1"));
		 * contents.add(new IncomingRecord("6", "5555", 1, 100, "note135 1"));
		 * contents.add(new IncomingRecord("7", "5555", 2, 500, "n453ote 1"));
		 * contents.add(new IncomingRecord("8", "5555", 3, 20, "no453453te 1"));
		 * 
		 */
		setDataVector(contents, columnNames);
	}

	
	@Override
	public void saveData() {
		super.saveData();
		System.out.println("save IncomingRecordData");
	}

}
