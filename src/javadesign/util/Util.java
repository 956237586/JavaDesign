package javadesign.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class provide some static method.
 * 
 * @author HYL
 *
 */
public class Util {
	/**
	 * Move a window to center of screen.
	 * 
	 * @param jFrame
	 *            a window which want to be move to center
	 */
	public static void displayAtCenter(JFrame jFrame) {
		int windowWidth = jFrame.getWidth();
		int windowHeight = jFrame.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		jFrame.setLocation((screenWidth - windowWidth) / 2,
				(screenHeight - windowHeight) / 2);
		jFrame.setVisible(true);
	}

	/**
	 * Show an error alert to user.
	 * 
	 * @param message
	 *            error message
	 */
	public static void alertError(String message) {
		JOptionPane.showMessageDialog(null, message, "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Password encode using MD5.
	 * 
	 * @param s
	 *            password which to be encode
	 * @return an string encode from MD5
	 */
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
			ret += (int) password[i] * i;
		}
		return ret;
	}

}
