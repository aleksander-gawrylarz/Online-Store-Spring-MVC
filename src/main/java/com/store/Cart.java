package com.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	
	private List<Optional<Article>> itemsInCart;
	
	public Cart() {
		itemsInCart = new ArrayList<>();
	}

	public List<Optional<Article>> getAllItemsInCart() {
		return itemsInCart;
	}
	
	public boolean deleteArticleById(int id) {
		for(Optional<Article> a : itemsInCart)
			if (a.get().getId() == id) {
				itemsInCart.remove(a);
			return true;	
			}
		return false;
	}
}
