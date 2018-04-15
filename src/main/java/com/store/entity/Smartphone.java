package com.store.entity;

import org.springframework.stereotype.Component;

import com.store.Article;
import com.store.Category;

@Component
public class Smartphone implements Article {
	
	private int id;
	private String brand;
	private String model;
	private double screenSize;
	private int price;
	private int storage;
	private String screenResolution;
	private String processor;
	
	private Category category = Category.SMARTPHONE;
	
	public Smartphone() {
		
	}
	
	public Smartphone(int id, String brand, String model, int price, double screenSize, int storage,
			String screenResolution, String processor) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.screenSize = screenSize;
		this.storage = storage;
		this.screenResolution = screenResolution;
		this.processor = processor;
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
	public int getPrice() {
		return price;
	}

	@Override
	public Category getCategory() {
		return category;
	}

	public double getScreenSize() {
		return screenSize;
	}
	
	@Override
	public String getModel() {
		return model;
	}

	public int getStorage() {
		return storage;
	}

	public String getScreenResolution() {
		return screenResolution;
	}

	public String getProcessor() {
		return processor;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", brand=" + brand + ", model=" + model + ", screenSize=" + screenSize
				+ ", price=" + price + "]";
	}
	
}
