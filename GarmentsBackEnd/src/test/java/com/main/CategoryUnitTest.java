/*package com.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DAO.CategoryDAO;
import com.model.Category;

public class CategoryUnitTest {
		static CategoryDAO categoryDAO;
		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.*");
		context.refresh();
			
			categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		}
		
		@Test
		public void addCategoryTest()
		{
			Category category=new Category();
			category.setCategoryName("Kids");
			category.setCategoryDescription("All kids wear");
			assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
		}
		
		
		@Test
		public void getCategoryTest()
		{
			assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
		}
		
		
		@Test
		public void deleteCategoryTest()
		{
			Category category=categoryDAO.getCategory(1);
			assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
		}

		@Test
		public void updateCategoryTest()
		{
			Category category=categoryDAO.getCategory(2);
			category.setCategoryName("garments styles");
			assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
		}
		
		@Test
		public void listCategoriesTest()
		{
			List<Category> listCategories=categoryDAO.getCategory();
			assertNotNull("No Categories",listCategories);
			
			for(Category category:listCategories)
			{
				System.out.print(category.getCategoryId()+":::");
				System.out.print(category.getCategoryName()+":::");
				System.out.println(category.getCategoryDescription());
			}
		}
}



*/