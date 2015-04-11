package javadesign.abstractmodel;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Data extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	protected Vector<ItemFromJTable> contents = new Vector<ItemFromJTable>();
	protected Vector<String> columnNames = new Vector<String>();

	public Data() {
	}

	public Data(String[] columnNames) {
		for (int i = 0; i < columnNames.length; i++) {
			this.columnNames.add(columnNames[i]);
		}
		loadData();
	}

	public void addItem(ItemFromJTable item) {
		if (item != null)
			contents.add(item);
		System.out.println("Ìí¼Ó³É¹¦£¡");
		saveData();
	}

	public void setContents(Vector<ItemFromJTable> contents) {
		this.contents = contents;
	}

	public Vector<ItemFromJTable> getContents() {
		return contents;
	}

	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}

	public ItemFromJTable getItemByKey(int key){
		return null;
	}
	
	public void loadData() {
	}

	public void saveData() {
	}

}
