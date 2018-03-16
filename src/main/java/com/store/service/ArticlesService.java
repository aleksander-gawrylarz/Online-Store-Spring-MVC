package com.store.service;

import java.util.List;

import com.store.Article;
import com.store.Category;

public interface ArticlesService {

	public List<Article> getArticles();

	public List<Article> getArticlesByBrand(String searchedBrand);
	
	public List<Article> getArticlesByCategory(Category searchedCategory);

	public List<Article> getFeaturedArticles();
}
