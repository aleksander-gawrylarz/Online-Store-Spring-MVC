package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.store.Cart;
import com.store.service.ArticlesService;

@Controller
@ControllerAdvice
public class HomeController {
	
	@Autowired
	private ArticlesService articlesService;
	
	@Autowired
	private Cart myCart;
	
	@ModelAttribute
	public void addAttributesToModel(Model model) {
		model.addAttribute("articles", articlesService.getFeaturedArticles());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
	}
	
	@GetMapping("/")
	public String showHomePage() {

		return "home-page";
	}
	
	@GetMapping("/cart-empty")
	public String makeCartEmpty() {
		
		myCart.getAllItemsInCart().clear();

		return "home-page";
	}
}
