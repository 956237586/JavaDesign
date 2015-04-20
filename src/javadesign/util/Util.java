package javadesign.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public static String encode(String s) {
		byte[] password = null;
		String ret = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			password = md5.digest(s.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < password.length; i++) {
			ret+=(int)password[i] * i;
		}
		return ret;
	}

}
