package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.DAO.CategoryDAO;
import com.DAO.CategoryDAOImpl;
import com.DAO.CustomerDAO;
import com.DAO.CustomerDAOImpl;
import com.DAO.ProductDAO;
import com.DAO.ProductDAOImpl;
import com.model.Authorities;
import com.model.BillingAddress;
import com.model.Cart;
import com.model.CartItem;
import com.model.Category;
import com.model.Customer;
import com.model.CustomerOrder;
import com.model.Product;
import com.model.ShippingAddress;
import com.model.User;
@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class DbConfig {
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Product.class);
     	factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Authorities.class);
		factoryBuilder.addAnnotatedClass(BillingAddress.class);
		factoryBuilder.addAnnotatedClass(Customer.class);
		factoryBuilder.addAnnotatedClass(ShippingAddress.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClass(Cart.class);
		factoryBuilder.addAnnotatedClass(CartItem.class);
		factoryBuilder.addAnnotatedClass(CustomerOrder.class);
		
		
		factoryBuilder.addProperties(hibernateProp);
		
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("---Product DAO Implementation ---");
		return new ProductDAOImpl();
	}
	@Bean(name="customerDAO")
	public CustomerDAO getCustomerDAO()
	{
		System.out.println("---Customer DAO Implementation ---");
		return new CustomerDAOImpl();
	}
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("---Category DAO Implementation ---");
		return new CategoryDAOImpl();
	}

	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}
}
