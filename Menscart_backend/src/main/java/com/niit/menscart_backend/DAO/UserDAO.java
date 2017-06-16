package com.niit.menscart_backend.DAO;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.menscart_backend.model.User;

@Transactional
@Repository("UserDAO")
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public User getByUserId(int userId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		 
		 return user;
	}
	public User getByEmailId(String emailId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, emailId);
		 
		 return user;
	}
	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();		
	}
	public void saveOrUpdate(User user) {
		
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
		}
	
	public void delete(int id) {
		User userToDelete = new User();
		userToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}
	
	
}
