package com.niit.menscart_backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.UserDAO;
import com.niit.menscart_backend.model.User;

public class UserTest {
	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		System.out.println("hai");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
		
		User user = (User) context.getBean("user");
		
		user.setUserName("Barani");
		user.setEmailId("barani04@gmail.com");
		user.setPassword("barani");
		user.setContactNo("9874561230");
		user.setAddress("30 xyz Street,abc,cbe-641016");
		user.setEnabled(true);
		
		userDAO.saveOrUpdate(user);
		
	}

}
