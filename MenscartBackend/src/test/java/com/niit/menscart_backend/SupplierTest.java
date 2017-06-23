package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.SupplierDAO;
import com.niit.menscart_backend.model.Supplier;

public class SupplierTest {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static SupplierDAO supdao;
	
	@Autowired static Supplier sup;
	
	public SupplierTest(){
		initialize();
		createSupplierTest();
	}
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		supdao = (SupplierDAO) context.getBean("SupplierDAO");
		
		sup = (Supplier) context.getBean("supplier");
	}
	
	@Test
	public void createSupplierTest(){
		sup.setSupplierName("Raji Silks");
		sup.setContactNo("6586361865");
		sup.setAddress("43 ncf Street,srinagar,Kasmir-563875");
		
		supdao.saveOrUpdate(sup);
	}
}
