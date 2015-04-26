package javadesign.specificmodel;

import javadesign.abstractmodel.ItemFromData;
import javadesign.util.Util;

public class User extends ItemFromData {
	private static final long serialVersionUID = 1L;
	private String username;
	private String passwordMD5;

	public User() {
		add(username);
		add(passwordMD5);
	}

	public User(String username, String password) {
		this();
		setUsername(username);
		setPassword(password);
	}

	public void setUsername(String username) {
		this.username = username;
		set(0, username);
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.passwordMD5 = Util.encode(password);
		set(1, this.passwordMD5);
	}

	public String getPasswordMD5() {
		return passwordMD5;
	}

}
