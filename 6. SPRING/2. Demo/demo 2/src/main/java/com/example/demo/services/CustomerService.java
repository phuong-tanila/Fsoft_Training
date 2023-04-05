package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entities.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> findAll() {
//		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return customerDAO.findAll();
		
//		return customerDAO.findByName("QUAN", Sort.by("name"));

	}

	public Customer findById(final Integer id) {
		return customerDAO.findById(id).get();
	}

	public void save(final Customer customer) {
		customerDAO.save(customer);
	}

	public void update(final Customer customer) {
		customerDAO.save(customer);
	}

	public void delete(final int id) {
		Customer customer = customerDAO.findById(id).get();
		if (customer != null) {
			customerDAO.delete(customer);
		}
	}
}
