package com.store.dao;

import java.util.List;
import java.util.Optional;

import com.store.Article;

public interface CartDAO {
	
	public List<Optional<Article>> getCartItems();
	
	public Optional<Article> getArticleById(int id);
	
}
