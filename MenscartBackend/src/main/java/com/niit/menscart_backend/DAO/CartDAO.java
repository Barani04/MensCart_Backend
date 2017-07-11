package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

	public CartDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Cart getByItemId(int itemId) {
		Cart cart = (Cart) sessionFactory.getCurrentSession().get(Cart.class, itemId);
		return cart;
	}

	public void saveOrUpdate(Cart cartitem) {

		sessionFactory.getCurrentSession().saveOrUpdate(cartitem);

	}

	public void save(Cart cartitem) {

		sessionFactory.getCurrentSession().save(cartitem);

	}

	@SuppressWarnings("unchecked")
	public List<Cart> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public List<Cart> getCartItems(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username and status='N'");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		return list;
	}

	public void deleteCartItem(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
	}

	public Cart getByUserandProduct(String username, int productId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username and productid=:productId");
		query.setParameter("username", username);
		query.setParameter("productId", productId);

		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	public boolean itemAlreadyExist(String username, int productId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username and productid=:productId");
		query.setParameter("username", username);
		query.setParameter("productId", productId);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}
	public boolean getByUserName(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username");
		query.setParameter("username", username);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public List<Cart> getDispatchItems(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username and status='Dispatched'");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		return list;
	}

}
