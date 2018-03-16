package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.store.Cart;
import com.store.service.ArticlesService;

@Controller
public class HomeController {
	
	@Autowired
	private ArticlesService articlesService;
	
	@Autowired
	private Cart myCart;
	
	@GetMapping("/")
	public String showHomePage(Model model) {

		model.addAttribute("articles", articlesService.getFeaturedArticles());
		model.addAttribute("inMyCart", myCart.getAllItemsInCart());
		
		return "home-page";
	}
}
