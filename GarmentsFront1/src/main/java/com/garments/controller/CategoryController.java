package com.garments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAO.CategoryDAO;
import com.model.Category;


@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/admin/category")
	public String showCategory(Model m) {
		List<Category> listCategories = categoryDAO.getCategory();
		m.addAttribute("listCategories", listCategories);

		for (Category category : listCategories) {
			System.out.println(category.getCategoryName() + ",");
		}
	
		return "Category";
	}

	@RequestMapping(value = "/admin/InsertCategory", method = RequestMethod.POST)
	public String insertCategoryData(@RequestParam("catname") String catname, @RequestParam("catdesc") String catdesc,
			Model m) {
		Category category = new Category();
		category.setCategoryName(catname);
		category.setCategoryDescription(catdesc);

		categoryDAO.addCategory(category);

		List<Category> listCategories = categoryDAO.getCategory();
		m.addAttribute("listCategories", listCategories);
	
		return "Category";
	}

	@RequestMapping("/admin/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		List listCategories=categoryDAO.getCategory();
		m.addAttribute("listCategories",listCategories);
	
		return "Category";
	}

	@RequestMapping("/admin/updateCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		
		List listCategories=categoryDAO.getCategory();
		m.addAttribute("listCategories",listCategories);
		m.addAttribute("categoryInfo",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/admin/UpdateCategory",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String categoryName,@RequestParam("catdesc") String categoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName
		(categoryName);
		category.setCategoryDescription(categoryDesc);
		System.out.println("inside update controller");
		categoryDAO.updateCategory(category);
		
		List listCategories=categoryDAO.getCategory();
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
	}
}



