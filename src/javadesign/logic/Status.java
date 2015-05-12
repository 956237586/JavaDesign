package javadesign.logic;

import java.util.HashMap;

import javadesign.abstractmodel.Window;

/**
 * This class is status of the program, it provide login user, login status and
 * all window has been created.
 * 
 * @author HYL
 *
 */
public class Status {
	private boolean isLogin;
	private String loginUsername;
	private HashMap<String, Window> windows = new HashMap<String, Window>();

	// when window create, it should be add into windows

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
