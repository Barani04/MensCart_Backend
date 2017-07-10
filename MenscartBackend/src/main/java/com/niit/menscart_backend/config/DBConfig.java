package com.niit.menscart_backend.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.menscart_backend.DAO.CartDAO;
import com.niit.menscart_backend.DAO.CategoryDAO;
import com.niit.menscart_backend.DAO.ProductDAO;
import com.niit.menscart_backend.DAO.RoleDAO;
import com.niit.menscart_backend.DAO.ShipmentDAO;
import com.niit.menscart_backend.DAO.SupplierDAO;
import com.niit.menscart_backend.DAO.UserDAO;
import com.niit.menscart_backend.model.Cart;
import com.niit.menscart_backend.model.Category;
import com.niit.menscart_backend.model.Product;
import com.niit.menscart_backend.model.Role;
import com.niit.menscart_backend.model.Shipment;
import com.niit.menscart_backend.model.Supplier;
import com.niit.menscart_backend.model.User;


@Configuration
@ComponentScan("com.niit.menscart_backend")
@EnableTransactionManagement
public class DBConfig {
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2DataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/mensCart");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
		}

	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipment.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

	return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
	return new UserDAO(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "CategoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
	return new CategoryDAO(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
	return new ProductDAO(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "SupplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory){
		return new SupplierDAO(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ShipmentDAO")
	public ShipmentDAO getShipmentDAO(SessionFactory sessionFactory){
		return new ShipmentDAO(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "CartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory){
		return new CartDAO(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "RoleDAO")
	public RoleDAO getRoleDAO(SessionFactory sessionFactory){
		return new RoleDAO(sessionFactory);
	}

}
