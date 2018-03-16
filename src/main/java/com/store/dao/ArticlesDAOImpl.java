package com.store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.Article;
import com.store.Category;
import com.store.StoreDatabase;

@Repository
public class ArticlesDAOImpl implements ArticlesDAO {
	
	@Autowired
	private StoreDatabase storeDatabase;
	
	@Override
	public List<Article> getArticles() {
		return storeDatabase.getAllArticles();
	}

	@Override
	public List<Article> getArticlesByBrand(String searchedBrand) {
		return storeDatabase.getByBrand(searchedBrand);
	}

	@Override
	public List<Article> getArticlesByCategory(Category searchedCategory) {
		return storeDatabase.getByCategory(searchedCategory);
	}

	@Override
	public Optional<Article> getArticleById(int id) {
		return storeDatabase.getById(id);
	}

}
