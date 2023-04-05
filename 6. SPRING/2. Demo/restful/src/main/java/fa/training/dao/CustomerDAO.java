package fa.training.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entities.Customer;


@Repository(value = "customerDAO")
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	List<Customer> findByName(String lastname, Sort sort);
}