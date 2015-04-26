package javadesign.abstractmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Data extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	protected Vector<ItemFromData> contents;
	protected Vector<String> columnNames = new Vector<String>();
	protected File dataFile;

	public Data() {
	}

	public Data(String[] columnNames) {
		for (int i = 0; i < columnNames.length; i++) {
			this.columnNames.add(columnNames[i]);
		}
		loadData();
	}

	public void addItem(ItemFromData item) {
		if (item != null)
			contents.add(item);
		System.out.println("添加成功！");
		saveData();
	}

	public void setContents(Vector<ItemFromData> contents) {
		this.contents = contents;
	}

	public Vector<ItemFromData> getContents() {
		return contents;
	}

	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}

	public ItemFromData getItemByKey(int key) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public void loadData() {
		System.out.println("super load data");
		try {
			FileInputStream fileInput = new FileInputStream(dataFile);
			ObjectInputStream dataInput = new ObjectInputStream(fileInput);
			contents = (Vector<ItemFromData>) dataInput.readObject();
			dataInput.close();
		} catch (FileNotFoundException e) {
			javadesign.util.Util.alertError("数据文件丢失，已经重新生成！");
			saveData();
			loadData();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void saveData() {
		System.out.println("super save data");
		try {
			FileOutputStream fileOutput = new FileOutputStream(dataFile);
			ObjectOutputStream dataOutput = new ObjectOutputStream(fileOutput);
			if (contents == null)
				contents = new Vector<ItemFromData>();

			dataOutput.writeObject(contents);
			dataOutput.flush();
			dataOutput.close();
		} catch (FileNotFoundException e) {
			dataFile.mkdirs();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
