package com.garments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAO.CategoryDAO;
import com.DAO.ProductDAOImpl;
import com.model.Category;
@Controller
public class PageController {
	//@Autowired
//	GarmentsProductDAOImpl productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping("getallproducts")
 public String getAllProducts()
{
	return "Category";
	}
	@RequestMapping("/getallupdation")
 public String getAllUpdation()
{
	return "UpdateCategory";
	}
	
		
		@RequestMapping("/")
		public String showHomePage()
		{
			return "index";
		}
		
		/*@RequestMapping("/login")
		 public String loginPage(@RequestParam(required=false) String error,@RequestParam(required=false) String logout,Model model){
		  if(error!=null)
		  model.addAttribute("error","Invalid Username/Password");
		  if(logout!=null)
		   model.addAttribute("msg","Loggedout successfully");
		  return "Login";}
*/
		@RequestMapping("/login")
		public String showLogin()
		{
			return"Login";
		}
		@RequestMapping("/aboutus")
		public String showAboutUs()
		{
			return "AboutUs";
		}
		
		
		@RequestMapping("/contactus")
		public String ContactUs()
		{
			return "ContactUs";
		}
		@RequestMapping("/Home")
		public String Home(Model m)
		{
			System.out.println("this method is triggered");
			List<Category> listcategory = categoryDAO.getCategory();
			System.out.println(listcategory);
			m.addAttribute("categories", listcategory);
			m.addAttribute("categories",categoryDAO.getCategory());
			
			return "Home";
		}
		@RequestMapping("/LandingPage")
		public String Page(Model m){
			System.out.println("this method is triggered");
			List<Category> listcategory = categoryDAO.getCategory();
			System.out.println(listcategory);
			m.addAttribute("categories", listcategory);
			m.addAttribute("categories",categoryDAO.getCategory());
			return "Home";
		}
		@RequestMapping("/SignUp")

		public String SignUp(){return "SignUp";}
		
		}
		
	













