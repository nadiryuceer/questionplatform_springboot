package com.Nadir.cs393project;

import com.Nadir.cs393project.model.*;
import com.Nadir.cs393project.service.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.util.AssertionErrors.*;

@EnableAutoConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Homework2ApplicationTests {
	@Autowired
	QuestionService addressService;
	@Autowired
	CustomerService customerService;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired
	ShopService shopService;

	Answer createShop(String name, String addr){
		Answer shop = new Answer();
		shop.setName(name);
		shop.setAddress(addr);
		return shop;
	}
	Question createAddress(String text, String city){
		Question address = new Question();
		address.setText(text);
		address.setCity(city);
		return address;
	}
	Tag createCustomer(String firstname, String lastname){
		Tag customer = new Tag();
		customer.setFirstName(firstname);
		customer.setLastName(lastname);
		return customer;
	}
	Comment createProduct(String name, double price){
		Comment product = new Comment();
		product.setName(name);
		product.setPrice(price);
		return product;
	}
	User createOrder(int amount){
		User order = new User();
		order.setAmount(amount);
		order.setDate(new Date(2021, Calendar.SEPTEMBER,25));
		return order;
	}
	/*@Test
	void Testtemplate() {
		Shop shop1 = createShop("Hepsiburada", "İstanbul");
		Shop shop2 = createShop("gittigidiyor", "İstanbul");
		Address address1 = createAddress("Kadıköy", "İstanbul");
		Address address2 = createAddress("Nişantaşı", "İstanbul");
		Customer customer1 = createCustomer("Nadir", "Yüceer");
		Customer customer2 = createCustomer("Mahmut", "Keser");
		Product product1 = createProduct("Ülker çikolatalı gofret", 1.50);
		Product product2 = createProduct("Pringles cips", 8.50);
		Order order1 = createOrder(500);
		Order order2 = createOrder(100);
	}*/

	@Test
	void ShopSaveTest(){
		Answer shop1 = createShop("Hepsiburada", "İstanbul");
		assertTrue("Shopsave",shopService.save(shop1));
		int shopid = shop1.getId();
		Tag customer1 = createCustomer("Nadir", "Yüceer");
		Question address1 = createAddress("Çekmeköy", "İstanbul");
		customer1.setAddress(address1);
		customer1.setBank(shopService.getShopById(shopid));
		assertTrue("Customersave",customerService.save(customer1));
		Comment product1 = createProduct("eti gofret", 1.50);
		product1.setShop(shop1);
		assertTrue("P1save",productService.save(product1));
		Comment product2 = createProduct("Playstation 5", 5249.99);
		product2.setShop(shop1);
		assertTrue("p2save",productService.save(product2));
		Comment product3 = createProduct("Xbox 360", 4599.99);
		product3.setShop(shop1);
		assertTrue("p3save",productService.save(product3));
		Answer shop2 = createShop("gittigidiyor", "İstanbul");
		assertTrue("Shop2save",shopService.save(shop2));
		Comment product4 = createProduct("Playstation 4", 3599.99);
		product4.setShop(shop2);
		assertTrue("p4save",productService.save(product4));
		Comment product5 = createProduct("Xbox 360", 4499.99);
		product5.setShop(shop2);
		assertTrue("p5save",productService.save(product5));
	}

}
