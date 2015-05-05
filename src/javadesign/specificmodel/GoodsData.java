package javadesign.specificmodel;

import java.io.File;

import javadesign.abstractmodel.Data;
import javadesign.abstractmodel.DataItem;
import javadesign.util.StaticValue;

public class GoodsData extends Data {
	private static final long serialVersionUID = 1L;
	public GoodsData() {
		super(StaticValue.GOODS_COLUMN_NAMES);
		//loadData();
	}

	@Override
	public void loadData() {
		dataFile=new File(StaticValue.DATA_GOOD);
		super.loadData();
		// 测试数据
		/*
		System.out.println();
		for (int i = 0; i < 10; i++) {
			contents.add(new Good(i,
					"" + (char) (531 * Math.random()) + i,
					"category" + i,
					(int)(100 * Math.random()), 
					200 * Math.random(),
					"note " + i));

		}
		*/
		/*/
		contents.add(new Good(1, "002", "category2", 100, 225, "note135 1"));
		contents.add(new Good(2, "02456450", "category1", 500, 200, "n453ote 1"));
		contents.add(new Good(3, "0664800", "category2", 20, 211,
				"no453453te 1"));
		contents.add(new Good(4, "012300", "category3", 51, 232, "no4534te 1"));
		contents.add(new Good(5, "041123", "category4", 0, 152, "note43354 1"));
		contents.add(new Good(6, "004560", "category5", 53, 252, "not78378e 1"));
		contents.add(new Good(7, "0045640", "category1", 3, 312, "no7387te 1"));
		//*/
		setDataVector(contents, columnNames);
	}

	@Override
	public DataItem getItemByKey(int key) {
		for (DataItem item : contents) {
			if (Integer.parseInt("" + item.get(0)) == key) {
				return item;
			}
		}
		return null;
	}
	
	@Override
	public void saveData() {
		super.saveData();
	}

}
