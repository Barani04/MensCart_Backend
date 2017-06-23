package com.niit.menscart_backend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.menscart_backend.DAO.CategoryDAO;
import com.niit.menscart_backend.model.Category;

public class CategoryTest {
	
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO  catdao;
	
	@Autowired  static Category cat;
	
	public CategoryTest(){
		initialize();
		createCategoryTest();
	}
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.menscart_backend");
		context.refresh();
		
		catdao =  (CategoryDAO) context.getBean("CategoryDAO");
		
		cat = (Category) context.getBean("category");
		
	}
	
	@Test
	public void createCategoryTest()
	{
		
		cat.setCategoryName("Clothing");
		cat.setDescription("This is the Clothing Section...");

		catdao.saveOrUpdate(cat);
	}


}
