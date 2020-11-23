package com.order.management.web.dto;

import java.io.Serializable;

import com.order.management.domain.Category;

public class ProductRequest implements Serializable {

	private static final long serialVersionUID = 4790254099338014263L;

	private String name;

	private Category category;

	private int quantity;

	private String brand;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", category=" + category + " quantity=" + quantity + ", brand=" + brand
				+ ", price=" + price + "]";
	}

}
