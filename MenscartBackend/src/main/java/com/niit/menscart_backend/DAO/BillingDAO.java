package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Billing;

@Transactional
@Repository("BillingDAO")
public class BillingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BillingDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Billing getByBillId(int billingId){
		Billing bill = (Billing) sessionFactory.getCurrentSession().get(Billing.class, billingId);
		return bill;
	}
	
	public void saveOrUpdate(Billing bill){
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
	}
	
	@SuppressWarnings("unchecked")
	public List<Billing> list(){
		return sessionFactory.getCurrentSession().createQuery("from Billing").list();
	}
	
	public void delete(int id){
		Billing billToDelete = new Billing();
		billToDelete.setBillId(id);
		sessionFactory.getCurrentSession().delete(billToDelete);
	}
	

}
