package javadesign.abstractmodel;

/**
 * This class is abstract form all of function of this program. Every instance
 * represent a menu item in the menu window. This class can set and get icon and
 * text of menu item.
 * 
 * @author HYL
 *
 */
public class MenuItem {

	private String iconPath;
	private String text;
	private int mouseStatus;// 0悬停 1按下 2松开

	public MenuItem() {

	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MenuItem(String iconPath, String text) {
		this.iconPath = iconPath;
		this.text = text;
	}

	public int getMouseStatus() {
		return mouseStatus;
	}

	public void setMouseStatus(int mouseStatus) {
		this.mouseStatus = mouseStatus;
	}

}
