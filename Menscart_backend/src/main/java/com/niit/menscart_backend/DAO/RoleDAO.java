package com.niit.menscart_backend.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("RoleDAO")
public class RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
