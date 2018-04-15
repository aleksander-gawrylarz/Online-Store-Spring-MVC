package com.store;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.entity.Laptop;
import com.store.entity.Smartphone;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=InternetStoreApplication.class)
public class CartTest {
	
	@Autowired
	private Cart cart;
	
	private List<Article> allArticles;
	
	@Before
	public void setUp() throws Exception {
		
		cart.getAllItemsInCart().clear();
		
		allArticles = new ArrayList<>();
		
		allArticles.add(new Laptop(1, "Asus", "GL502VM", 5499, 8, 15.6, "NVIDIA GeForce GTX 1060", "Intel Core i7-7700HQ"));
		allArticles.add(new Smartphone(8, "Apple", "iPhone SE", 1399, 4.0, 16, "1136x640", "Apple A9"));
		allArticles.add(new Smartphone(9, "Apple", "iPhone 6s", 2100, 4.7, 16, "1334x750", "Apple A9"));
	}
	
	@Test
	public void CartStartsEmpty() {
		assertTrue(cart.getAllItemsInCart().isEmpty());
	}
	
	@Test
	public void whenDeleteArticleByExistingIdCartSizeIsDecreasedByOne() {
		
		cart.getAllItemsInCart().add(getById(1));
		cart.getAllItemsInCart().add(getById(1));
		cart.getAllItemsInCart().add(getById(9));
		
		cart.deleteArticleById(1);
		assertEquals(2, cart.getAllItemsInCart().size());
		
		cart.deleteArticleById(9);
		assertEquals(1, cart.getAllItemsInCart().size());
		
		cart.deleteArticleById(1);
		assertTrue(cart.getAllItemsInCart().isEmpty());
	}
	
	@Test
	public void whenDeleteArticleByExistingIdReturnsTrue() {
		
		cart.getAllItemsInCart().add(getById(1));
		
		assertTrue(cart.deleteArticleById(1));
	}
	
	@Test
	public void whenDeleteArticleByNotExistingIdReturnsFalse() {
		
		cart.getAllItemsInCart().add(getById(1));
		
		assertFalse(cart.deleteArticleById(100));
	}
	
	public Optional<Article> getById(int id){
		return allArticles.stream().filter(element -> element.getId() == id).findFirst();
	}

}
