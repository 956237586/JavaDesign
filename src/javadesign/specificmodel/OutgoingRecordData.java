package javadesign.specificmodel;

import java.io.File;

import javadesign.util.StaticValue;

public class OutgoingRecordData extends OperateRecordData {
	private static final long serialVersionUID = 1L;

	public OutgoingRecordData() {
		super(StaticValue.OUTGOING_COLUMN_NAMES);
	}

	@Override
	public void loadData() {
		dataFile = new File(StaticValue.DATA_OUTGOING);
		super.loadData();
		// test data
		/*
		 * / for (int i = 0; i < 10; i++) { contents.add(new
		 * OutgoingRecord(""+i, "hyl" + i, (int)(10 * Math.random()), (int)(200
		 * * Math.random()), "note " + i)); } //
		 */
		/*
		 * / contets.add(new OutgoingRecord("1", "5555", 0, 50, "note 1"));
		 * contents.add(new OutgoingRecord("2", "5555", 1, 100, "note135 1"));
		 * contents.add(new OutgoingRecord("3", "5555", 2, 500, "n453ote 1"));
		 * contents.add(new OutgoingRecord("4", "5555", 3, 20, "no453453te 1"));
		 * contents.add(new OutgoingRecord("5", "5555", 0, 50, "note 1"));
		 * contents.add(new OutgoingRecord("6", "5555", 1, 100, "note135 1"));
		 * contents.add(new OutgoingRecord("7", "5555", 2, 500, "n453ote 1"));
		 * contents.add(new OutgoingRecord("8", "5555", 3, 20, "no453453te 1"));
		 * //
		 */

		setDataVector(contents, columnNames);
	}

	@Override
	public void saveData() {
		super.saveData();
		System.out.println("save OutgoingRecordData");
	}

}
