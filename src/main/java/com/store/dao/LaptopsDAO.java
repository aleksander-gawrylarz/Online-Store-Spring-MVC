package com.store.dao;

import java.util.List;
import java.util.Optional;

import com.store.entity.Laptop;

public interface LaptopsDAO {
	
	public List<Laptop> getLaptops();

	public List<Laptop> getLaptopsByBrand(String searchedBrand);
		
	public Optional<Laptop> getLaptopsById(int id);

	public List<Laptop> getLaptopsByPrice(int min, int max);

}
