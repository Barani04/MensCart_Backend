package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Supplier;

@Transactional
@Repository("SupplierDAO")
public class SupplierDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public SupplierDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Supplier getBySupplierId(int supplierId){
		Supplier sup = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplierId);
		return sup;
	}
	
	public void saveOrUpdate(Supplier sup){
		sessionFactory.getCurrentSession().saveOrUpdate(sup);
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier>  list(){
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}
	
	public void delete(int id){
		Supplier supToDelete = new Supplier();
		supToDelete.setSupplierId(id);
		sessionFactory.getCurrentSession().delete(supToDelete);
	}
	

}
