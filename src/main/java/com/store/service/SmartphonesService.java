package com.store.service;

import java.util.List;
import java.util.Optional;

import com.store.entity.Smartphone;

public interface SmartphonesService {
	
	public List<Smartphone> getSmartphones();
	
	public List<Smartphone> getSmartphonesByScreenSize(String screenSizeRange);
	
	public Optional<Smartphone> getSmartphonesById(int id);
	
	public List<String> getScreenSizeList();

}
