package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.ProductDAO;
import com.niit.menscart_backend.model.Product;

public class ProductTest {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static ProductDAO prodao;
	@Autowired static Product pro;

	public ProductTest(){
		initialize();
		createProductTest();
	}
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		prodao = (ProductDAO) context.getBean("ProductDAO");
		
		pro =  (Product) context.getBean("product");
	}
	
	@Test
	public void createProductTest(){
		pro.setProductName("T-shirt");
		pro.setProductDescription("Casual Wear...");
		pro.setStock(50);
		pro.setPrice(200);
		pro.setSupplierId(5);
		pro.setCategoryId(1);
		
		prodao.saveOrUpdate(pro);
	}
}
