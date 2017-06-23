package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Category;

@Transactional
@Repository("CategoryDAO")
public class CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Category getByCategoryId(int categoryId){
		Category cat = (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
		return cat;
	}
	
	public void saveOrUpdate(Category cat){
		
		sessionFactory.getCurrentSession().saveOrUpdate(cat);
		
	}

	@SuppressWarnings("unchecked")
	public List<Category> list(){
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	public void delete(int id){
		Category catToDelete = new Category();
		catToDelete.setCategoryId(id);
		sessionFactory.getCurrentSession().delete(catToDelete);
	}

}
