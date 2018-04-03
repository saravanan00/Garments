package com.DAO; 
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.model.Product;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {
		@Autowired
		SessionFactory sessionFactory;
		
		public boolean addCategory(Category category) {
			// TODO Auto-generated method stub
			try
			{
			sessionFactory.getCurrentSession().save(category);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised:"+e);
			return false;
			}
		}
		public boolean updateCategory(Category category) {
			{
				  // TODO Auto-generated method stub
				  try
				  {
				  sessionFactory.getCurrentSession().update(category);
				  System.out.println("BEFORE INSERT/UPDATE " + category.getCategoryId());
				  //if id==0, insert query
				  //if id exits in the table, update query
				 //INsert into product values (?,.....)
				  System.out.println("AFTER INSERT/UPDATE " + category.getCategoryId());
				  return true;
				  }
				  catch(Exception e) {
				   System.out.println("Exception Arised:"+e);
				   
				  }
				  return false;
				  
				 }
		}

		public Category getCategory(int categoryId) {

			  // TODO Auto-generated method stub
			  Session session=sessionFactory.openSession();
			  Category category=(Category)session.get(Category.class,categoryId);
			  return category;
			 }

		public List<Category> getCategory() {
			  // TODO Auto-generated method stub
			  
			  //HQL - Hibernate query Language
			//Select * from Category
			  return sessionFactory.getCurrentSession().createQuery("from Category").list(); //List of Category objects
			  }

		public boolean deleteCategory(Category category) { try {
			   sessionFactory.getCurrentSession().delete(category);
			   //Category category1=(Category)session.get(Category.class,product.getCategoryId());
			   return true;
			   }
			   catch(Exception e) {
			    System.out.println("Exception Arised:"+e);
			   return false;
			   }
			  }
}
		
		