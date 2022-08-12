package com.satishlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.satishlabs.entity.Customer;
import com.satishlabs.exception.CityNotFoundException;
import com.satishlabs.exception.CustomerIdNotFoundException;
import com.satishlabs.exception.InvalidPhoneNumberException;
import com.satishlabs.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/custId/{cid}")
	public Customer getCustomerByCid(@PathVariable int cid) {
		//Customer cust = customerService.getCustomerByCid(cid);
		//return cust;
		
		Customer cust =null;
		try {
			cust = customerService.getCustomerByCid(cid);
		}catch (CustomerIdNotFoundException  ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Id is not available",ex);
		}
		return cust;
	}
	
	@GetMapping("/customer/phone/{phone}")
	public Customer getCustomerByPhone(@PathVariable long phone) {
		Customer cust=null;
		try {
			cust = customerService.getCustomerByPhone(phone);
		}catch (InvalidPhoneNumberException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"This phone number is invalid "+ex);
		}
		return cust;
	}
	
	@GetMapping("/customer/city/{city}")
	public List<Customer> getCustomerByCity(@PathVariable("city") String city){
		System.out.println("CC- getCustomerByCity()  - "+city);
		List<Customer> custList = null;
		try {
			custList = customerService.getCustomerByCity(city);
		}catch (CityNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This city is not available",ex);
		}
		return custList;
	}
}
