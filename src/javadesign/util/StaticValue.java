package javadesign.util;

import java.awt.Font;

public class StaticValue {
	public static final int DEFAULT_WIDTH = 1024;
	public static final int DEFAULT_HEIGHT = 768;
	public static final int DEFAULT_BUTTON_NUM = 4;//GeneralFrame默认按钮个数
	public static final Font DEFAULT_FONT = new Font("SimSun", Font.PLAIN, 15);
	public static final int INDEX_GOOD_ID = 0; // ID 0
	public static final int INDEX_GOOD_NAME = 1; // 名称 1
	public static final int INDEX_GOOD_CATEGORY = 2; // 类别 2
	public static final int INDEX_GOOD_QUANTITY = 3; // 数量 3
	public static final int INDEX_GOOD_UNIT_PRICE = 4; // 单价 4
	public static final int INDEX_GOOD_TOTAL_PRICE = 5; // 总价 5
	public static final int INDEX_GOOD_NOTE = 6; // 备注 6
	public static final int INDEX_OPERATOR = 7;	//操作员姓名 7
	public static final int INDEX_INCOMING_NO = 8; //入库单号 8
	public static final int INDEX_OUTGOING_NO = 9; //出库单号 9
	public static final String[] GOODS_COLUMN_NAMES = 
		{ "货物ID", "名称", "类别", "库存", "单价", "总价", "备注", };
	public static final String[] OUTGOING_COLUMN_NAMES = 
		{"出库单号","操作员", "货物ID", "名称", "类别", "数量", "单价", "总价", "备注", };
	public static final String[] INCOMING_COLUMN_NAMES = 
		{"入库单号","操作员", "货物ID", "名称", "类别", "数量", "单价", "总价", "备注", };
	public static final String DATA_USER = "userdata.dat";
	public static final String DATA_GOOD = "gooddata.dat";
	public static final String DATA_INCOMING = "incomingdata.dat";
	public static final String DATA_OUTGOING = "outgoingdata.dat";
}
