package com.store.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.StoreDatabase;
import com.store.entity.Laptop;

@Repository
public class LaptopsDAOImpl implements LaptopsDAO {
	
	@Autowired
	private StoreDatabase storeDatabase;
	
	@Override
	public List<Laptop> getLaptops() {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Laptop)
				.map(element -> (Laptop)element)
				.collect(Collectors.toList());
	}

	@Override
	public List<Laptop> getLaptopsByBrand(String searchedBrand) {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Laptop)
				.map(element -> (Laptop)element)
				.filter(element -> element.getBrand().equals(searchedBrand))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Laptop> getLaptopsById(int id) {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Laptop)
				.map(element -> (Laptop)element)
				.filter(element -> element.getId() == id).findFirst();
	}

	@Override
	public List<Laptop> getLaptopsByPrice(int min, int max) {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Laptop)
				.map(element -> (Laptop)element)
				.filter(element -> (element.getPrice() >= min && element.getPrice() <= max))
				.collect(Collectors.toList());
	}

}
