package com.store.service;

import java.util.List;

import com.store.entity.Smartphone;

public interface SmartphonesService {
	
	public List<Smartphone> getSmartphones();
	
	public List<Smartphone> getSmartphonesByScreenSize(String screenSizeRange);
	
	public List<String> getScreenSizeList();

}
