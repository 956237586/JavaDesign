package javadesign.windows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javadesign.abstractmodel.Window;
import javadesign.specificmodel.GeneralFrame;
import javadesign.util.StaticValue;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddWindow extends Window implements KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel[] labels;
	private JTextField[] textFields;
	private GeneralFrame createWindow;
	private int currentIndex = 0;

	public AddWindow(GeneralFrame createWindow, String[] propertieNames) {
		this.createWindow = createWindow;
		status.getWindows().put("AddWindow", this);

		setTitle("添加");
		
		setResizable(false);
		getContentPane().setLayout(null);

		labels = new JLabel[propertieNames.length];
		textFields = new JTextField[propertieNames.length];

		for (int i = 0; i < propertieNames.length; i++) {
			labels[i] = new JLabel(propertieNames[i]);
			textFields[i] = new JTextField();
			labels[i].setFont(StaticValue.DEFAULT_FONT);
			labels[i].setBounds(10, 10 + i * 32, 86, 22);
			textFields[i].setBounds(106, 10 + i * 32, 104, 22);
			textFields[i].addKeyListener(this);
			getContentPane().add(labels[i]);
			getContentPane().add(textFields[i]);
		}
		setSize(225, (labels.length + 1) * 32 + 10);
		setup();
		textFields[0].requestFocus();
	}

	public void createItem() {
		String[] properties = new String[labels.length];
		for (int i = 0; i < properties.length; i++) {
			properties[i] = textFields[i].getText();
			if (properties[i].equals(""))
				properties[i] = "0";
		}
		createWindow.addItem(properties);// 数据回传给上一个窗口
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) {
			if (currentIndex < labels.length - 1) {
				textFields[++currentIndex].requestFocus();
			} else {
				createItem();
				this.dispose();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
