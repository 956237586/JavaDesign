package javadesign.abstractmodel;

import java.util.Vector;

/**
 * This abstract model is abstract form all of item data.
 * 
 * @author HYL
 *
 */
public class DataItem extends Vector<Object> {
	private static final long serialVersionUID = 1L;
	protected String note; // 备注

	public void setNote(String note) {
		this.note = note;
		add(note);
	}

	public String getNote() {
		return note;
	}
}
