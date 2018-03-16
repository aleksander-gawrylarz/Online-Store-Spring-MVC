package com.store.service;

import java.util.List;
import java.util.Optional;

import com.store.Article;

public interface CartService {
	
	public List<Article> getCartItems();
	
	public Optional<Article> getArticleById(int id);
	
	public int totalPrice();

}
