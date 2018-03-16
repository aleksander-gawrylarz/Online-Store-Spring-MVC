package com.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Article;
import com.store.Category;
import com.store.dao.ArticlesDAO;

@Service
public class ArticlesServiceImpl implements ArticlesService {
	
	@Autowired
	private ArticlesDAO articlesDAO;

	@Override
	public List<Article> getArticles() {
		return articlesDAO.getArticles();
	}

	@Override
	public List<Article> getArticlesByBrand(String searchedBrand) {
		return articlesDAO.getArticlesByBrand(searchedBrand);
	}

	@Override
	public List<Article> getArticlesByCategory(Category searchedCategory) {
		return articlesDAO.getArticlesByCategory(searchedCategory);
	}

	@Override
	public List<Article> getFeaturedArticles() {
		
		List<Article> featuredArticles = new ArrayList<>();
		featuredArticles.add(articlesDAO.getArticles().get(4));
		featuredArticles.add(articlesDAO.getArticles().get(7));
		featuredArticles.add(articlesDAO.getArticles().get(12));
		
		return featuredArticles;
	}

}
