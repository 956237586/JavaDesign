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

/**
 * This class is an abstract model of the data, which is the basic class in all
 * of this system. This class have two property store data's contents and data
 * properties' name. The data will be write in to a file automatically.
 * 
 * @author HYL
 *
 */
public class Data extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	protected Vector<DataItem> contents;
	protected Vector<String> columnNames = new Vector<String>();
	protected File dataFile;

	public Data() {
	}

	/**
	 * Using some data item properties' name to create a Data instance.
	 * 
	 * @param columnNames
	 *            data item properties' name
	 */
	public Data(String[] columnNames) {
		for (int i = 0; i < columnNames.length; i++) {
			this.columnNames.add(columnNames[i]);
		}
		loadData();
	}

	/**
	 * Add item to data file.
	 * 
	 * @param item
	 *            data item
	 */
	public void addItem(DataItem item) {
		if (item != null)
			contents.add(item);
		System.out.println("添加成功！");
		saveData();
	}

	public void setContents(Vector<DataItem> contents) {
		this.contents = contents;
	}

	public Vector<DataItem> getContents() {
		return contents;
	}

	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}

	public DataItem getItemByKey(int key) {
		return null;
	}

	/**
	 * Load data form file, If file not found, it will create an empty data
	 * file.
	 */
	@SuppressWarnings("unchecked")
	public void loadData() {
		System.out.println("super load data");
		try {
			FileInputStream fileInput = new FileInputStream(dataFile);
			ObjectInputStream dataInput = new ObjectInputStream(fileInput);
			contents = (Vector<DataItem>) dataInput.readObject();
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

	/**
	 * Save data to file, if data file not exist, it will create an empty data
	 * file.
	 */
	public void saveData() {
		System.out.println("super save data");
		try {
			FileOutputStream fileOutput = new FileOutputStream(dataFile);
			ObjectOutputStream dataOutput = new ObjectOutputStream(fileOutput);
			if (contents == null)
				contents = new Vector<DataItem>();

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
