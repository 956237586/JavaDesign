package javadesign.specificmodel;

import java.awt.Component;

import javadesign.abstractmodel.ItemFromJList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class IconListRenderer extends JButton implements
		ListCellRenderer<Object> {
	private static final long serialVersionUID = 1L;

	public IconListRenderer() {
	};

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		ItemFromJList item = (ItemFromJList) value;
		float size = list.getFont().getSize();

		// 加入宽度为5的空白边框
		setBorder(new EmptyBorder(5, 5, 5, 5));
		if (item.getMouseStatus() == 0 && isSelected) {
			setFont(list.getFont().deriveFont(size + 3));
		} else if (item.getMouseStatus() == 1) {
			setFont(list.getFont().deriveFont(size - 1));
		} else {
			setFont(list.getFont());
		}
		setIcon(new ImageIcon(item.getIconPath()));
		setText(item.getText());
		setContentAreaFilled(false);
		// item.setVisible(true);
		return this;
	}

}