package com.store;

import static org.junit.Assert.*;

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
public class StoreDatabaseTest {
	
	@Autowired
	private StoreDatabase storeDatabase;

	@Before
	public void setUp() throws Exception {
		storeDatabase.getAllArticles().clear();
		
		storeDatabase.getAllArticles().add(new Laptop(1, "Asus", "GL502VM", 5499, 8, 15.6, "NVIDIA GeForce GTX 1060", "Intel Core i7-7700HQ"));
		storeDatabase.getAllArticles().add(new Laptop(2, "Asus", "Vivobook Pro", 3399, 8, 15.6, "NVIDIA GeForce GTX 1050", "Intel Core i5-7300HQ"));
		storeDatabase.getAllArticles().add(new Laptop(3, "MSI", "GT72VR", 6499, 16, 17.3, "NVIDIA GeForce GTX 1060", "Intel Core i7-6700HQ"));
		storeDatabase.getAllArticles().add(new Smartphone(12, "Apple", "iPhone X", 4750, 5.8, 64, "2436x1125", "Apple A11 Bionic"));
		storeDatabase.getAllArticles().add(new Smartphone(13, "Samsung", "Galaxy S9+", 3999, 6.2, 64, "2960x1440", "Samsung Exynos 9810"));
		storeDatabase.getAllArticles().add(new Smartphone(14, "Google", "Pixel 2", 3150, 5.0, 64, "1920x1080", "Qualcomm Snapdragon 835"));
	}

	@Test
	public void getByBrandShouldReturnListWhichSizeEqualsToNumberOfArticlesWithThatBrand() {
		
		List<Article> asus = storeDatabase.getByBrand("Asus");
		List<Article> apple = storeDatabase.getByBrand("Apple");
		List<Article> kawasaki = storeDatabase.getByBrand("Kawasaki");
		
		assertEquals(2, asus.size());
		assertEquals(1, apple.size());
		assertTrue(kawasaki.isEmpty());
	}

	@Test
	public void getByCategoryShouldReturnListWhichSizeEqualsToNumberOfArticlesWithThatCategory() {
		
		List<Article> laptop = storeDatabase.getByCategory(Category.LAPTOP);
		List<Article> smartphone = storeDatabase.getByCategory(Category.SMARTPHONE);
		
		assertEquals(3, laptop.size());
		assertEquals(3, smartphone.size());
	}

	@Test
	public void whenGetByExistingIdThenReturnsTrue() {
		
		Optional<Article> temp = storeDatabase.getById(1);
		Optional<Article> temp2 = storeDatabase.getById(12);
		
		assertTrue(temp.isPresent());
		assertTrue(temp2.isPresent());
	}
	
	@Test
	public void whenGetByNotExistingIdThenReturnsFalse() {
		
		Optional<Article> temp = storeDatabase.getById(0);
		Optional<Article> temp2 = storeDatabase.getById(-12);
		Optional<Article> temp3 = storeDatabase.getById(999);
		
		assertFalse(temp.isPresent());
		assertFalse(temp2.isPresent());
		assertFalse(temp3.isPresent());
	}
	

	@Test
	public void getByPriceRangeShouldReturnListWhichSizeEqualsToNumberOfArticlesWithinThatPriceRange() {
		
		List<Article> priceFilter = storeDatabase.getByPriceRange(3999, 5500);
		List<Article> priceFilter2 = storeDatabase.getByPriceRange(Integer.MAX_VALUE, Integer.MIN_VALUE);
		
		assertEquals(3, priceFilter.size());
		assertEquals(0, priceFilter2.size());
		
	}
}
