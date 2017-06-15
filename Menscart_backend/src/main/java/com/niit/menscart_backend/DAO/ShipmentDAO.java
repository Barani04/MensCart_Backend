package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Shipment;

@Transactional
@Repository("ShipmentDAO")
public class ShipmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ShipmentDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Shipment getByShipmentId(int shipmentId){
		Shipment ship =(Shipment) sessionFactory.getCurrentSession().get(Shipment.class, shipmentId);
		return ship;
	}
	
	public void saveOrUpdate(Shipment ship){
		
		sessionFactory.getCurrentSession().saveOrUpdate(ship);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Shipment> list(){
		
		return sessionFactory.getCurrentSession().createQuery("from Shipment").list();
	}
	
	public void delete(int id){
		Shipment shipToDelete = new Shipment();
		shipToDelete.setShipmentId(id);
		sessionFactory.getCurrentSession().delete(shipToDelete);
	}
}
