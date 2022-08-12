package com.satishlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.entity.Customer;
import com.satishlabs.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/custId/{cid}")
	public Customer getCustomerByCid(@PathVariable int cid) {
		Customer cust = customerService.getCustomerByCid(cid);
		return cust;
	
	}
	
	@GetMapping("/customer/phone/{phone}")
	public Customer getCustomerByPhone(@PathVariable long phone) {
		Customer cust=customerService.getCustomerByPhone(phone);
		return cust;
	}
	
	@GetMapping("/customer/city/{city}")
	public List<Customer> getCustomerByCity(@PathVariable("city") String city){
		System.out.println("CC- getCustomerByCity()  - "+city);
		List<Customer> custList = customerService.getCustomerByCity(city);
		return custList;
	}
}
