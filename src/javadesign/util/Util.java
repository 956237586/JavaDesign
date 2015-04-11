package javadesign.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Util {
	public static void displayAtCenter(JFrame jFrame) {
		// ��������Ϊ����
		int windowWidth = jFrame.getWidth(); // ��ô��ڿ�
		int windowHeight = jFrame.getHeight(); // ��ô��ڸ�
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // ��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; // ��ȡ��Ļ�Ŀ�
		int screenHeight = screenSize.height; // ��ȡ��Ļ�ĸ�
		jFrame.setLocation((screenWidth - windowWidth) / 2,
				(screenHeight - windowHeight) / 2); // ���ô��ھ�����ʾ
		jFrame.setVisible(true);
	}

	public static void alertError(String message) {
		JOptionPane.showMessageDialog(null, message, "����",
				JOptionPane.ERROR_MESSAGE);
	}

}
