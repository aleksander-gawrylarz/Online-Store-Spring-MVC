package com.store.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Utility;
import com.store.dao.LaptopsDAO;
import com.store.entity.Laptop;

@Service
public class LaptopsServiceImpl implements LaptopsService {
	
	@Autowired
	private LaptopsDAO laptopsDAO;

	@Override
	public List<Laptop> getLaptops() {
		return laptopsDAO.getLaptops();
	}

	@Override
	public List<Laptop> getLaptopsByBrand(String searchedBrand) {
		return laptopsDAO.getLaptopsByBrand(searchedBrand);
	}

	@Override
	public Optional<Laptop> getLaptopsById(int id) {
		return laptopsDAO.getLaptopsById(id);
	}

	@Override
	public Set<String> getLaptopsBrand() {
		
		List<Laptop> laptops = getLaptops();
		Set<String> uniqueBrands = new TreeSet<>();
		
		for (Laptop laptop: laptops) {
			uniqueBrands.add(laptop.getBrand());
		}
		
		return uniqueBrands;
		
	}

	@Override
	public List<Laptop> getLaptopsByPrice(String minPrice, String maxPrice) {

		int min = 0;
		int max = Integer.MAX_VALUE;

		if (minPrice == null)
			minPrice = Integer.toString(min);
		if (maxPrice == null)
			maxPrice = Integer.toString(max);

		if (Utility.numberOrNot(minPrice) && Utility.numberOrNot(maxPrice)) {
			min = Integer.parseInt(minPrice);
			max = Integer.parseInt(maxPrice);
		}

		if (min >= 0 && max >= 0 && min <= max) {
			return laptopsDAO.getLaptopsByPrice(min, max);
		} else
			return laptopsDAO.getLaptops();
	}
}
