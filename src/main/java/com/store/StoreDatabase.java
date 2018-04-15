package com.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.store.entity.Laptop;
import com.store.entity.Smartphone;

@Component
public class StoreDatabase {

	private List<Article> allArticles;
	
	public StoreDatabase() {
		allArticles = new ArrayList<>();
		
		allArticles.add(new Laptop(1, "Asus", "GL502VM", 5499, 8, 15.6, "NVIDIA GeForce GTX 1060", "Intel Core i7-7700HQ"));
		allArticles.add(new Laptop(2, "Asus", "Vivobook Pro", 3399, 8, 15.6, "NVIDIA GeForce GTX 1050", "Intel Core i5-7300HQ"));
		allArticles.add(new Laptop(3, "MSI", "GT72VR", 6499, 16, 17.3, "NVIDIA GeForce GTX 1060", "Intel Core i7-6700HQ"));
		allArticles.add(new Laptop(4, "MSI", "GS63", 4799, 8, 15.6, "NVIDIA GeForce GTX 1050", "Intel Core i7-7700HQ"));
		allArticles.add(new Laptop(5, "Lenovo", "Y720", 5189, 16, 15.6, "NVIDIA GeForce GTX 1060", "Intel Core i5-7300HQ"));
		allArticles.add(new Laptop(6, "Lenovo", "Ideapad 320", 2500, 8, 15.6, "Intel UHD Graphics 620", "Intel Core i5-8250U"));
		allArticles.add(new Smartphone(7, "Samsung", "Galaxy S7", 1800, 5.1, 32, "2560x1440", "Samsung Exynos 8890"));
		allArticles.add(new Smartphone(8, "Apple", "iPhone SE", 1399, 4.0, 16, "1136x640", "Apple A9"));
		allArticles.add(new Smartphone(9, "Apple", "iPhone 6s", 2100, 4.7, 16, "1334x750", "Apple A9"));
		allArticles.add(new Smartphone(10, "LG", "G6", 1700, 5.7, 32, "2880x1440", "Qualcomm Snapdragon 821"));
		allArticles.add(new Smartphone(11, "Samsung", "Galaxy S7 Edge", 2100, 5.5, 32, "2560x1440", "Samsung Exynos 8890"));
		allArticles.add(new Smartphone(12, "Apple", "iPhone X", 4750, 5.8, 64, "2436x1125", "Apple A11 Bionic"));
		allArticles.add(new Smartphone(13, "Samsung", "Galaxy S9+", 3999, 6.2, 64, "2960x1440", "Samsung Exynos 9810"));
		allArticles.add(new Smartphone(14, "Google", "Pixel 2", 3150, 5.0, 64, "1920x1080", "Qualcomm Snapdragon 835"));
		
	}

	public List<Article> getAllArticles() {
		return allArticles;
	}

	public List<Article> getByBrand(String brand){
		
		List<Article> byBrandList = allArticles.stream()
					.filter(element -> element.getBrand().equals(brand))
					.collect(Collectors.toList());
		
		return byBrandList;
	}
	
	public List<Article> getByCategory(Category category){
		
		List<Article> byCategoryList = allArticles.stream()
					.filter(element -> element.getCategory().equals(category))
				        .collect(Collectors.toList());
		
		return byCategoryList;
	}
	
	public Optional<Article> getById(int id){
		return allArticles.stream().filter(element -> element.getId() == id).findFirst();
	}
	
	public List<Article> getByPriceRange(int minPrice, int maxPrice){
		
		List<Article> byPriceRangeList = allArticles.stream()
				.filter(element -> (element.getPrice() >= minPrice && element.getPrice() <= maxPrice))
				.collect(Collectors.toList());
		
		return byPriceRangeList;
	}
	
}
