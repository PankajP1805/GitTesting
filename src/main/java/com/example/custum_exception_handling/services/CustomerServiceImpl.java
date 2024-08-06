package com.example.custum_exception_handling.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.custum_exception_handling.exception.CustomerAlreadyExistsException;
import com.example.custum_exception_handling.exception.NoSuchCustomerExistsException;
import com.example.custum_exception_handling.model.Customer;
import com.example.custum_exception_handling.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("NO CUSTOMER PRESENT WITH ID = " + id));
	}

	@Override
	public String addCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);

		if (existingCustomer == null) {
			customerRepository.save(customer);
			return "Customer added successfully";
		} else {
			throw new CustomerAlreadyExistsException("Customer already exists!!");
		}
	}

	@Override
	public String updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
		if(existingCustomer == null)
		{
			throw new NoSuchCustomerExistsException("No such customer exists!!");
		}
		else {
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			customerRepository.save(existingCustomer);
			return "Record updated Successfully";
		}
	}

}
