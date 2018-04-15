package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.Cart;
import com.store.service.SmartphonesService;

@Controller
@ControllerAdvice
public class SmartphonesController {
	
	@Autowired
	private SmartphonesService smartphonesService;
	
	@Autowired
	private Cart myCart;
	
	@ModelAttribute
	public void addAttributesToModel(Model model) {
		model.addAttribute("screenSizeList", smartphonesService.getScreenSizeList());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
	}
	
	@GetMapping("/category/smartphones")
	public String smartphones(Model model) {
		
		model.addAttribute("smartphones", smartphonesService.getSmartphones());
	
		return "smartphones";
	}
	
	@GetMapping("/category/smartphones-by-screen-size")
	public String smartphonesByScreen(@RequestParam("screenSize") String screenSize, Model model) {
		
		model.addAttribute("smartphones", smartphonesService.getSmartphonesByScreenSize(screenSize));

		return "smartphones-by-param";
	}
	
	@GetMapping("/category/smartphone-info")
	public String laptopInfo(@RequestParam("ArticleId") int id, Model model) {
		
		model.addAttribute("smartphone", smartphonesService.getSmartphonesById(id).get());
		
		return "smartphone-info";
	}

}
