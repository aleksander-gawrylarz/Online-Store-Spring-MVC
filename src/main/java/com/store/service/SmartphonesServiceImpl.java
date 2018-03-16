package com.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.SmartphonesDAO;
import com.store.entity.Smartphone;

@Service
public class SmartphonesServiceImpl implements SmartphonesService {
	
	@Autowired
	private SmartphonesDAO smartphonesDAO;

	@Override
	public List<Smartphone> getSmartphones() {
		return smartphonesDAO.getSmartphones();
	}

	@Override
	public List<Smartphone> getSmartphonesByScreenSize(String screenSizeRange) {
		
		List<String> screenSizeList = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\d\\.\\d");
		Matcher matcher = pattern.matcher(screenSizeRange);
		
		while(matcher.find()) {
			screenSizeList.add(matcher.group());
		}
		
		return smartphonesDAO.getSmartphonesByScreenSize(Double.parseDouble(screenSizeList.get(0)), 
				Double.parseDouble(screenSizeList.get(1)));
	}

	@Override
	public List<String> getScreenSizeList() {
		
		List<String> screenSizeList = new ArrayList<>();
		screenSizeList.add("4.0\" - 4.5\"");
		screenSizeList.add("4.6\" - 5.0\"");
		screenSizeList.add("5.1\" - 5.5\"");
		screenSizeList.add("5.6\" - 6.2\"");
		
		return screenSizeList;
	}

}
