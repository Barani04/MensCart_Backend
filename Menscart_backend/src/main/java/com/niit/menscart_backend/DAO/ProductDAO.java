package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Product;

@Transactional
@Repository("ProductDAO")
public class ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAO(SessionFactory sessionFactory){
		this.sessionFactory =sessionFactory;
	}
	
	public Product getByProductId(int productId){
		Product pro = (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
		return pro;
	}
	
	public Product getByProductName(String productName){
		Product pro = (Product) sessionFactory.getCurrentSession().get(Product.class, productName);
		return pro;
	}

	public void saveOrUpdate(Product pro){
		sessionFactory.getCurrentSession().saveOrUpdate(pro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> list(){
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	public void delete(int id){
		Product proToDelete = new Product();
		proToDelete.setProductId(id);
		sessionFactory.getCurrentSession().delete(proToDelete);
	}
}
