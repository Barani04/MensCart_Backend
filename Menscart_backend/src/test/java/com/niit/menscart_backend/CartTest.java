package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.CartDAO;
import com.niit.menscart_backend.model.Cart;

public class CartTest {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static CartDAO cartdao;
	@Autowired static Cart cart;
	
	public CartTest(){
		initialize();
		createCartTest();
		
	}
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		cartdao = (CartDAO) context.getBean("CartDAO");
		cart = (Cart) context.getBean("cart");
		
	}
	
	@Test
	public void createCartTest(){
		cart.setDays(9);
		cart.setEmailId("hgf@gmail.com");
		cart.setPrice(90);
		cart.setProductId(6);
		cart.setProductName("tyah");
		cart.setQty(67);
		cart.setShipmentId(89);
		cart.setStatus("approved");
		cart.setTotal(678);
		cart.setUserId(7);
		cart.setUserName("kumar");
		
		cartdao.saveOrUpdate(cart);
	}
	
}
