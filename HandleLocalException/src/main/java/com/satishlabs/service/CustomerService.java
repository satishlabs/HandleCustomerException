package com.satishlabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.satishlabs.entity.Customer;
import com.satishlabs.exception.CityNotFoundException;
import com.satishlabs.exception.CustomerIdNotFoundException;
import com.satishlabs.exception.InvalidPhoneNumberException;

@Service
public class CustomerService {
	public Customer getCustomerByCid(int custId) {
		Customer cust=null;
		if(custId >= 100) {
			cust = new Customer(custId, "Satish", "satish@gmail", 11111, "Ranchi");
		}else {
			throw new CustomerIdNotFoundException();
		}
		return cust;
	}
	
	
	public Customer getCustomerByPhone(long phone) {
		Customer cust=null;
		if(phone >= 5000) {
			cust = new Customer(109, "Satish", "satish@gmail", phone, "Ranchi");
		}else {
			throw new InvalidPhoneNumberException();
		}
		return cust;
	}
	
	public List<Customer> getCustomerByCity(String city) {
		List<Customer> custList = new ArrayList<>();
		if(city.equals("Bangalore")) {
			custList.add(new Customer(101, "Satish", "satish@gmail.com", 11111, "Ranchi"));
			custList.add(new Customer(102, "Dande", "dande@gmail.com", 22222, "Ranchi"));
			custList.add(new Customer(103, "Mahesh", "mah@gmail.com", 3333, "Bangalore"));
			custList.add(new Customer(104, "Shankar", "shankh@gmail.com", 44444, "Ranchi"));
			custList.add(new Customer(105, "Vasudev", "vasu@gmail.com", 55555, "Bangalore"));
		}else {
			throw new CityNotFoundException();
		}
		return custList;
	}
}
