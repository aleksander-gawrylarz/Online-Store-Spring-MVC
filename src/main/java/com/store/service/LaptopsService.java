package com.store.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.store.entity.Laptop;

public interface LaptopsService {
	
	public List<Laptop> getLaptops();

	public List<Laptop> getLaptopsByBrand(String searchedBrand);
		
	public Optional<Laptop> getLaptopsById(int id);

	public Set<String> getLaptopsBrand();

	public List<Laptop> getLaptopsByPrice(String minPrice, String maxPrice);

}
