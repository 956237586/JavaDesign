package javadesign.specificmodel;

import java.util.Vector;

import javadesign.abstractmodel.Data;
import javadesign.abstractmodel.ItemFromData;
import javadesign.util.Util;

public class UserData extends Data {
	private static final long serialVersionUID = 1L;

	@Override
	public void loadData() {
		// 测试数据
		contents = new Vector<ItemFromData>();
		String username = "admin";
		contents.add(new User(username, username));
	}

	@Override
	public void saveData() {
	}

	public boolean canAccess(String username, String password) {
		for (ItemFromData item : contents) {
			if (item.get(0).equals(username)
					&& item.get(1).equals(Util.encode(password))) {
				return true;
			}
		}
		return false;
	}
}
