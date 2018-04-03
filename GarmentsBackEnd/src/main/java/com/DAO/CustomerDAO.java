package com.DAO;

import com.model.Customer;
import com.model.User;

public interface CustomerDAO {
	public boolean isEmailValid(String email);
	public boolean isUsernameValid(String username);
	public void registerCustomer(Customer customer);
	public User getUser(String username);

}
