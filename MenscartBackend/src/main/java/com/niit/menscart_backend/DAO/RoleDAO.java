package com.niit.menscart_backend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.menscart_backend.model.Role;

@Transactional
@Repository("RoleDAO")
public class RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Role> list(){
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
								.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRole;
	}
	
	@SuppressWarnings("unchecked")
	public Role getByUserName(String userName){
			String sql = "from Role where userName ='" + userName + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Role> listRole = (List<Role>) (query).list();

			if (listRole != null && !listRole.isEmpty()) {
				return listRole.get(0);
			}
			return null; 
	}

	@SuppressWarnings("unchecked")
	public Role getByEmailId(String emailId) {
		String sql = "from Role where emailId ='" + emailId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(sql);
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Role getByContactNo(int contactNo) {
		String sql = "from Role where contactNumber ='" + contactNo + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(sql);
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}
	
	public void saveOrUpdate(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}

	public void delete(String userName) {
		Role roleToDelete = new Role();
		roleToDelete.setUserName(userName);
		sessionFactory.getCurrentSession().delete(roleToDelete);
		
	}
	

	

}
