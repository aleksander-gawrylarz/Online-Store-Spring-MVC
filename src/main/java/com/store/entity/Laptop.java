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
	private int memory;
	private double screenSize;
	private String graphicCard;
	private String processor;
	
	private Category category = Category.LAPTOP;
	
	public Laptop() {
		
	}

	public Laptop(int id, String brand, String model, int price, int memory, double screenSize, String graphicCard,
			String processor) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.memory = memory;
		this.screenSize = screenSize;
		this.graphicCard = graphicCard;
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
	
	public int getMemory() {
		return memory;
	}
	
	public double getScreenSize() {
		return screenSize;
	}

	public String getGraphicCard() {
		return graphicCard;
	}

	public String getProcessor() {
		return processor;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}

}
