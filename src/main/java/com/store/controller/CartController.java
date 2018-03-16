package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.Cart;
import com.store.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private Cart myCart;
	
	@GetMapping("/cart/list")
	public String cartItemsList(Model model) {
		
		model.addAttribute("cartItems", cartService.getCartItems());
		model.addAttribute("totalPrice", cartService.totalPrice());
		
		return "cart-list";
	}
	
	@GetMapping("/cart-delete")
	public String deleteArticleFromCart(@RequestParam("ArticleId") int id) {
		
		myCart.deleteArticleById(id);
		return "redirect:/cart/list";
	}
	
	@GetMapping("/cart-add")
	public String addArticleToCart(@RequestParam("ArticleId") int id, Model model) {
		
		myCart.getAllItemsInCart().add(cartService.getArticleById(id));
		
		model.addAttribute("totalPrice", cartService.totalPrice());
		model.addAttribute("cartItems", cartService.getCartItems());
		
		return "cart-info";
	}
	
}
