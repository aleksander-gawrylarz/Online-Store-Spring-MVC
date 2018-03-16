package com.store.entity;

import org.springframework.stereotype.Component;

import com.store.Article;
import com.store.Category;

@Component
public class Laptop implements Article {

	private int id;
	private String brand;
	private String model;
	private int price;
	
	private Category category = Category.LAPTOP;
	
	public Laptop() {
		
	}

	public Laptop(int id, String brand, String model, int price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}

}
