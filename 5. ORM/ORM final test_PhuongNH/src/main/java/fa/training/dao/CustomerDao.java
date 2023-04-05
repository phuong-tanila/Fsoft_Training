package fa.training.dao;

import java.util.List;

import org.hibernate.HibernateException;

import fa.training.constants.CustomerType;
import fa.training.entities.Customer;


public interface CustomerDao {
	boolean save(Customer customer) throws HibernateException;
	
	boolean delete(final long customerId) throws HibernateException;

	int updateAddress(long customerId, String address) throws HibernateException;
	
	Customer findCustomerById(long customerId);
	
	List<Customer>listOfCustomerByType(CustomerType type);
	
	Long getTotalCustomerBySexAndBirthday();
}
