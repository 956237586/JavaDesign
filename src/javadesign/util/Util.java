package javadesign.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Util {
	public static void displayAtCenter(JFrame jFrame) {
		// 启动设置为居中
		int windowWidth = jFrame.getWidth(); // 获得窗口宽
		int windowHeight = jFrame.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		jFrame.setLocation((screenWidth - windowWidth) / 2,
				(screenHeight - windowHeight) / 2); // 设置窗口居中显示
		jFrame.setVisible(true);
	}

	public static void alertError(String message) {
		JOptionPane.showMessageDialog(null, message, "错误",
				JOptionPane.ERROR_MESSAGE);
	}

}
