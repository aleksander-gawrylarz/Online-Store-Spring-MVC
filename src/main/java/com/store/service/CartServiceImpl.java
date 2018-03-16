package com.store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.Article;
import com.store.dao.CartDAO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List<Article> getCartItems() {
		return cartDAO.getCartItems().stream()
				.map(Optional::get)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Article> getArticleById(int id) {
		return cartDAO.getArticleById(id);
	}

	@Override
	public int totalPrice() {
		return cartDAO.getCartItems().stream()
				.map(Optional::get)
				.mapToInt(Article::getPrice)
				.sum();
	}

}
