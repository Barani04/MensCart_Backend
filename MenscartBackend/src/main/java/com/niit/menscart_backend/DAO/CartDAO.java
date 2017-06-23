package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Cart;

@Transactional
@Repository("CartDAO")
public class CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Cart getByCartId(int cartId){
		 Cart cart = (Cart) sessionFactory.getCurrentSession().get(Cart.class, cartId);
		 return cart;
	}
	
	public void saveOrUpdate(Cart cart){
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> list(){
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	public void delete(int id){
		Cart cartToDelete = new Cart();
		cartToDelete.setCartId(id);
		sessionFactory.getCurrentSession().delete(cartToDelete);
	}
}
