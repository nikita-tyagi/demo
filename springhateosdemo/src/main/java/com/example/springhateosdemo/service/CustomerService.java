package com.example.springhateosdemo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springhateosdemo.model.Customer;

@Service
public class CustomerService {

	private List<Customer> customerList = Arrays.asList(
			new Customer(1, "Nikita", "GlobalLogic"),
			new Customer(2, "Pallavi", "GlobalLogic"),
			new Customer(3, "Kundan", "GlobalLogic")
    );

	public Customer getCustomerDetail(int customerId) {
		
		return customerList.stream().filter(x -> x.getCustomerId() == customerId).findFirst().orElse(null);
	}
}
