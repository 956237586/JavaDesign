package javadesign.util;

import java.awt.Font;

public class StaticValue {
	public static final int DEFAULT_WIDTH = 1024;
	public static final int DEFAULT_HEIGHT = 768;
	public static final int DEFAULT_BUTTON_NUM = 4;//GeneralFrameĬ�ϰ�ť����
	public static final Font DEFAULT_FONT = new Font("SimSun", Font.PLAIN, 15);
	public static final int INDEX_GOOD_ID = 0; // ID 0
	public static final int INDEX_GOOD_NAME = 1; // ���� 1
	public static final int INDEX_GOOD_CATEGORY = 2; // ��� 2
	public static final int INDEX_GOOD_QUANTITY = 3; // ���� 3
	public static final int INDEX_GOOD_UNIT_PRICE = 4; // ���� 4
	public static final int INDEX_GOOD_TOTAL_PRICE = 5; // �ܼ� 5
	public static final int INDEX_GOOD_NOTE = 6; // ��ע 6
	public static final int INDEX_OPERATOR = 7;	//����Ա���� 7
	public static final int INDEX_INCOMING_NO = 8; //��ⵥ�� 8
	public static final int INDEX_OUTGOING_NO = 9; //���ⵥ�� 9
	public static final String[] GOODS_COLUMN_NAMES = 
		{ "����ID", "����", "���", "���", "����", "�ܼ�", "��ע", };
	public static final String[] OUTGOING_COLUMN_NAMES = 
		{"���ⵥ��","����Ա", "����ID", "����", "���", "����", "����", "�ܼ�", "��ע", };
	public static final String[] INCOMING_COLUMN_NAMES = 
		{"��ⵥ��","����Ա", "����ID", "����", "���", "����", "����", "�ܼ�", "��ע", };

}
