package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.response.ResponseTransfer;
import com.example.demo.services.CustomerService;

@RestController
public class CustomerController {
	private Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_XML_VALUE)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@GetMapping(value = "/findall", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> doUpdateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer)
			throws Exception {
		customerService.findById(id).orElseThrow(() -> new Exception("customer not found: " + id));
		customer.setId(id);
		final Customer updatedCustomer = customerService.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) throws Exception {
		customerService.findById(id).orElseThrow(() -> new Exception("User not found: " + id));
		customerService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping(value = "/response", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseTransfer postResponseController(@RequestBody Customer customer) {
		return new ResponseTransfer("Thanks For Posting!!!");
	}

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

//	@GetMapping("/age")
//	public ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
//		if (isInFuture(yearOfBirth)) {
//			return new ResponseEntity<>("Year of birth cannot be in the future", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>("Your age is " + calculateAge(yearOfBirth), HttpStatus.OK);
//	}

	@GetMapping("/age")
	ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
		if (isInFuture(yearOfBirth)) {
			return ResponseEntity.badRequest().body("Year of birth cannot be in the future");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Your age is " + calculateAge(yearOfBirth));

	}

	private boolean isInFuture(int yearOfBirth) {
		return yearOfBirth > 2023;
	}

	private int calculateAge(int yearOfBirth) {
		return 2023 - yearOfBirth;
	}

}
