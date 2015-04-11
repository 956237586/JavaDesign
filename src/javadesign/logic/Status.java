package javadesign.logic;

import java.util.HashMap;

import javadesign.abstractmodel.Window;

public class Status {
	private boolean isLogin;
	private String loginUsername;
	private HashMap<String, Window> windows = new HashMap<String, Window>();

	public HashMap<String, Window> getWindows() {
		return windows;
	}

	public Window getWindow(String key) {
		return windows.get(key);
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

}
