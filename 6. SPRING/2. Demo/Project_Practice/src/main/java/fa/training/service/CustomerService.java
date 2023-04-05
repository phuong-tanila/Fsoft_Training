package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	public Customer findById(final int id) {
		return customerDAO.findById(id);
	}

	public void save(final Customer customer) {
		customerDAO.save(customer);
	}

	public void update(final Customer customer) {
		customerDAO.update(customer);
	}

	public void delete(final int id) {
		Customer customer = customerDAO.findById(id);
		if (customer != null) {
			customerDAO.delete(customer);
		}
	}
}
