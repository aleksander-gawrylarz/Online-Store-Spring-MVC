package com.store.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.Article;
import com.store.Cart;
import com.store.StoreDatabase;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private StoreDatabase storeDatabase;
	
	@Autowired
	private Cart cart;

	@Override
	public List<Optional<Article>> getCartItems() {
		return cart.getAllItemsInCart();
	}

	@Override
	public Optional<Article> getArticleById(int id) {
		return storeDatabase.getById(id);
	}

}
