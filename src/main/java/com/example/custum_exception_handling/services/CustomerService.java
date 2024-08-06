package com.example.custum_exception_handling.services;

import com.example.custum_exception_handling.model.Customer;

public interface CustomerService {
	
	Customer getCustomer(Long id);
	
	String addCustomer(Customer customer);
	
	String updateCustomer(Customer customer);
	

}
