package javadesign.specificmodel;

import javadesign.abstractmodel.ItemFromJTable;

public class Good extends ItemFromJTable {
	private static final long serialVersionUID = 1L;
	private int id; // ID 0
	private String name; // 名称 1
	private String category; // 类别 2
	private int quantity; // 数量 3 可能是库存，也可能是操作数
	private double unitPrice; // 单价 4
	private double totalPrice; // 总价 5

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
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}


}
