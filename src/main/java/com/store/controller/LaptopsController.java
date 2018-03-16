package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.Cart;
import com.store.service.LaptopsService;

@Controller
public class LaptopsController {
	
	@Autowired
	private LaptopsService laptopsService;
	
	@Autowired
	private Cart myCart;
	
	@GetMapping("/category/laptops")
	public String laptops(Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptops());
		model.addAttribute("brands", laptopsService.getLaptopsBrand());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "laptops";
	}
	
	@GetMapping("/category/laptops-by-brand")
	public String laptopsByBrand(@RequestParam("brand") String brand, Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptopsByBrand(brand));
		model.addAttribute("brands", laptopsService.getLaptopsBrand());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "laptops-by-param";
	}
	
	@GetMapping("/category/laptops-by-price")
	public String laptopsByPrice(@RequestParam("minPrice") String minPrice, 
			@RequestParam("maxPrice") String maxPrice, Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptopsByPrice(minPrice, maxPrice));
		model.addAttribute("brands", laptopsService.getLaptopsBrand());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "laptops-by-param";
	}
	
}
