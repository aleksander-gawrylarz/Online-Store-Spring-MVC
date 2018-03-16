package com.store.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.StoreDatabase;
import com.store.entity.Smartphone;

@Repository
public class SmartphonesDAOImpl implements SmartphonesDAO {
	
	@Autowired
	private StoreDatabase storeDatabase;

	@Override
	public List<Smartphone> getSmartphones() {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Smartphone)
				.map(element -> (Smartphone)element)
				.collect(Collectors.toList());
	}

	@Override
	public List<Smartphone> getSmartphonesByScreenSize(double min, double max) {
		return storeDatabase.getAllArticles().stream()
				.filter(element -> element instanceof Smartphone)
				.map(element -> (Smartphone)element)
				.filter(element -> (element.getScreenSize() >= min && element.getScreenSize() <= max))
				.collect(Collectors.toList());
	}

}
