package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.ShipmentDAO;
import com.niit.menscart_backend.model.Shipment;

public class ShipmentTest {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static ShipmentDAO shipdao;
	@Autowired static Shipment ship;
	
	public ShipmentTest(){
		initialize();
		createShipmentTest();
	}
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		shipdao = (ShipmentDAO) context.getBean("ShipmentDAO");
		ship = (Shipment) context.getBean("shipment");
	}
	
	@Test
	public void createShipmentTest()
	{
		ship.setUserName("Vinodh");
		ship.setAddress("ch c cd cgdyc ");
		ship.setContactNo("9535256412");
		ship.setEmailId("cgdvcbdbdb@gmail.com");
		ship.setUserId(1);

		shipdao.saveOrUpdate(ship);
	}
}
