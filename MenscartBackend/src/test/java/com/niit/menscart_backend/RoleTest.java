package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.RoleDAO;
import com.niit.menscart_backend.model.Role;

public class RoleTest {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static RoleDAO roledao;
	@Autowired static Role role;
	
	public RoleTest(){
		initialize();
		createRoleTest();
	}
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		roledao = (RoleDAO) context.getBean("RoleDAO");
		role = (Role) context.getBean("role");
	}
	
	@Test
	public void createRoleTest(){
		role.setUserName("Sathish");
		role.setRole("user");
		role.setEmailId("hja@gmail.com");
		role.setContactNo("7865231490");
		
		roledao.saveOrUpdate(role);
	}

}
