package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.Query;
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
	

	public User getByUserName(String userName) {
		String sql = "from User where username='" + userName + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
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

	public boolean isAllReadyRegister(String username, boolean b) {

		String hql = "from User where userName='" + username + "'";

		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;

	}

}
