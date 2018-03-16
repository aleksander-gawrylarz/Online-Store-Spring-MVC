package com.store.dao;

import java.util.List;
import java.util.Optional;

import com.store.Article;
import com.store.Category;

public interface ArticlesDAO {
	
	public List<Article> getArticles();

	public List<Article> getArticlesByBrand(String searchedBrand);
	
	public List<Article> getArticlesByCategory(Category searchedCategory);
	
	public Optional<Article> getArticleById(int id);
	
}
