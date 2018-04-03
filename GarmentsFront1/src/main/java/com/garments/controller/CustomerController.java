package com.garments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CustomerDAO;
import com.model.Customer;

@Controller
public class CustomerController {
	@Autowired
private CustomerDAO customerDAO;
@RequestMapping(value="/all/registrationform") 	
public    ModelAndView  getRegistrationForm(){
	return new ModelAndView("RegistrationForm","customer",new Customer());
}
@RequestMapping(value="/all/registercustomer")
public ModelAndView registerCustomer( @ModelAttribute Customer customer,BindingResult result,Model model){
	
	if(!customerDAO.isUsernameValid(customer.getUser().getUsername())){//duplicate username
		model.addAttribute("duplicateUsername","Username already exists.. please enter different username");
		return new ModelAndView("RegistrationForm");
	}
	if(!customerDAO.isEmailValid(customer.getEmail())){//duplicate email address
		model.addAttribute("duplicateEmail","Email Id already exists.. Please enter different email address");
		return new ModelAndView("RegistrationForm");
	}
	else {
	customerDAO.registerCustomer(customer);//valid 
	return new ModelAndView("Login");
	}
}
}
