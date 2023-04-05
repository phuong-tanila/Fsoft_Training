package com.example.demo.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;

@Controller
public class CustomerController {
	private Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value={"/", "/customer-list"})
	public String listCustomer(Model model) {
		logger.info("View Customer List");
		
		model.addAttribute("listCustomer", customerService.findAll());
		return "customer-list";
	}

	@RequestMapping("/customer-save")
	public String insertCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-save";
	}

	@RequestMapping(value = {"/customer-view"}, method = RequestMethod.GET)
//	@GetMapping("/view")
	public String viewCustomer(@RequestParam Optional<Integer> id, Model model) {
		if(!id.isPresent()) {
			model.addAttribute("customer", new Customer());
		}else {
			Customer customer = customerService.findById(id.get());
			model.addAttribute("customer", customer);
		}
		return "customer-view";
//		return ResponseEntity.status(HttpStatus.OK).body(model);
	}
	
//	@RequestMapping("/customer-view/{id}")
//	public String viewCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-view";
//	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public RedirectView save(@ModelAttribute("Customer") Customer customer, Model model,
			RedirectAttributes redirectAttrs) {
		customerService.save(customer);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/customer-list");
		return redirectView;
	}
	
	@RequestMapping("/customer-update/{id}")
	public String updateCustomer(@PathVariable int id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "customer-update";
	}


	@RequestMapping("/updateCustomer")
	public String doUpdateCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
		customerService.update(customer);
		model.addAttribute("listCustomer", customerService.findAll());
		return "customer-list";
	}
	
	@RequestMapping("/customerDelete/{id}")
	public String doDeleteCustomer(@PathVariable int id, Model model) {
		customerService.delete(id);
		model.addAttribute("listCustomer", customerService.findAll());
		return "customer-list";
	}
}
