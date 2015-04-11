package javadesign.abstractmodel;

import java.util.Vector;


public class ItemFromJTable extends Vector<Object>{
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
