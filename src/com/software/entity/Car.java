package com.software.entity;

public class Car {
	private long id;
	private String carNumber;
	private long brandId;
	private String model;
	private String color;
	private long categoryId;
	private String comments;
	private double price;
	private double rent;
	private int status;
	private int userable;
	private String brand;
	private String category;

	public Car() {
		super();
	}

	public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String comments,
			double price, double rent, int status, int userable) {
		super();
		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.color = color;
		this.categoryId = categoryId;
		this.comments = comments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.userable = userable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserable() {
		return userable;
	}

	public void setUserable(int userable) {
		this.userable = userable;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carNumber=" + carNumber + ", brandId=" + brandId + ", model=" + model + ", color="
				+ color + ", categoryId=" + categoryId + ", comments=" + comments + ", price=" + price + ", rent="
				+ rent + ", status=" + status + ", userable=" + userable + "]";
	}

}
