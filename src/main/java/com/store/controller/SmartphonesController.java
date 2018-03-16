package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.Cart;
import com.store.service.SmartphonesService;

@Controller
public class SmartphonesController {
	
	@Autowired
	private SmartphonesService smartphonesService;
	
	@Autowired
	private Cart myCart;
	
	@GetMapping("/category/smartphones")
	public String smartphones(Model model) {
		
		model.addAttribute("smartphones", smartphonesService.getSmartphones());
		model.addAttribute("screenSizeList", smartphonesService.getScreenSizeList());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "smartphones";
	}
	
	@GetMapping("/category/smartphones-by-screen-size")
	public String smartphonesByScreen(@RequestParam("screenSize") String screenSize, Model model) {
		
		model.addAttribute("smartphones", smartphonesService.getSmartphonesByScreenSize(screenSize));
		model.addAttribute("screenSizeList", smartphonesService.getScreenSizeList());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "smartphones-by-param";
	}

}
