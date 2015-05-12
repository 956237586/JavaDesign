package javadesign.specificmodel;

import javadesign.abstractmodel.DataItem;

public class Good extends DataItem {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String category;
	// maybe store number or operate number
	private int quantity;
	private double unitPrice;
	private double totalPrice;

	public Good() {
		add(id);
		add(name);
		add(category);
		add(quantity);
		add(unitPrice);
		add(totalPrice);
		add(note);
	}

	public Good(int id, String name, String category, int quantity,
			double unitPrice, String note) {
		this();
		setId(id);
		setName(name);
		setCategory(category);
		setQuantity(quantity);
		setUnitPrice(unitPrice);
		setNote(note);
	}

	public void setId(int id) {
		this.id = id;
		set(0, id);
	}

	public void setName(String name) {
		this.name = name;
		set(1, name);
	}

	public void setCategory(String category) {
		this.category = category;
		set(2, category);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		calculateTotalPrice();
		set(3, quantity);
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		calculateTotalPrice();
		set(4, unitPrice);
	}

	public void calculateTotalPrice() {
		this.totalPrice = unitPrice * quantity;
		set(5, totalPrice);
	}

	@Override
	public void setNote(String note) {
		this.note = note;
		set(6, note);
	}

	public int getId() {
		return (Integer) get(0);
	}

	public String getName() {
		return (String) get(1);
	}

	public String getCategory() {
		return (String) get(2);
	}

	public int getQuantity() {
		return Integer.parseInt(get(3) + "");
	}

	public double getUnitPrice() {
		return (Double) get(4);
	}

	public double getTotalPrice() {
		return (Double) get(5);
	}

}
