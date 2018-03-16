package com.store.dao;

import java.util.List;

import com.store.entity.Smartphone;

public interface SmartphonesDAO {
	
	public List<Smartphone> getSmartphones();
	
	public List<Smartphone> getSmartphonesByScreenSize(double min, double max);

}
