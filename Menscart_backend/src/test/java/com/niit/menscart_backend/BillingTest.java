package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.BillingDAO;
import com.niit.menscart_backend.model.Billing;

public class BillingTest {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static BillingDAO billdao;
	@Autowired static Billing bill;
	
	public BillingTest(){
		initialize();
		createCategoryTest();
	}
	
	@BeforeClass
	public static void  initialize() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		billdao = (BillingDAO) context.getBean("BillingDAO");
		bill = (Billing) context.getBean("billing");
		
	}
	
	@Test
	public void createCategoryTest() {
		bill.setUserId(8);
		bill.setUserName("harish");
		bill.setEmailId("hyu@gmail.com");
		bill.setContactNo("8565231497");
		bill.setAddress("12 xcy,cvd-897654");
		
		billdao.saveOrUpdate(bill);
		
	}

}
