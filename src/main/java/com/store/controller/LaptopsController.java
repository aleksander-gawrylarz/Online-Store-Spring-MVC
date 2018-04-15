package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.Cart;
import com.store.service.LaptopsService;

@Controller
@ControllerAdvice
public class LaptopsController {
	
	@Autowired
	private LaptopsService laptopsService;
	
	@Autowired
	private Cart myCart;
	
	@ModelAttribute
	public void addAttributesToModel(Model model) {
		model.addAttribute("brands", laptopsService.getLaptopsBrand());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
	}
	
	@GetMapping("/category/laptops")
	public String laptops(Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptops());
		
		return "laptops";
	}
	
	@GetMapping("/category/laptops-by-brand")
	public String laptopsByBrand(@RequestParam("brand") String brand, Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptopsByBrand(brand));

		return "laptops-by-param";
	}
	
	@GetMapping("/category/laptops-by-price")
	public String laptopsByPrice(@RequestParam("minPrice") String minPrice, 
			@RequestParam("maxPrice") String maxPrice, Model model) {
		
		model.addAttribute("laptops", laptopsService.getLaptopsByPrice(minPrice, maxPrice));
		
		return "laptops-by-param";
	}
	
	@GetMapping("/category/laptop-info")
	public String laptopInfo(@RequestParam("ArticleId") int id, Model model) {
		
		model.addAttribute("laptop", laptopsService.getLaptopsById(id).get());
		
		return "laptop-info";
	}
	
}
