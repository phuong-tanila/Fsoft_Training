package fa.training.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fa.training.entities.Customer;
import fa.training.entities.MyOtherGlass;
import fa.training.service.CustomerService;

@Controller
//@PropertySource(value = "classpath:employee.properties")
public class CustomerController {
	private Logger logger = Logger.getLogger(CustomerController.class);

	@Value("#{'${MSG1}'}")
	private String msg1;
	@Value("#{'${MSG2}'}")
	private String msg2;
	@Value("#{'${MSG3}'}")
	private String msg3;
	@Value("#{'${MSG4}'}")
	private String msg4;
	@Value("#{'${MSG5}'}")
	private String msg5;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MyOtherGlass smallGlass;
	
	
	@Autowired
	private MyOtherGlass largeGlass;
	

	@RequestMapping(value={"/", "/customer-list"})
	public String listCustomer(Model model) {
		logger.info("View Customer List");
		
		
		logger.info(smallGlass.isLargeGlass());
		logger.info(largeGlass.isLargeGlass());
		
		logger.info(msg1);
		
		model.addAttribute("listCustomer", customerService.findAll());
		return "customer-list";
	}

	@RequestMapping("/customer-save")
	public String insertCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-save";
	}

//	@RequestMapping("/customer-view/{id}")
//	public String viewCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-view";
//	}
	
	@RequestMapping("/customer-view")
	public String viewCustomer(@RequestParam Optional<Integer> id, Model model) {
		if(!id.isPresent()) {
			model.addAttribute("customer", new Customer());
		}else {
			Customer customer = customerService.findById(id.get());
			model.addAttribute("customer", customer);
		}
		return "customer-view";
	}
	
//	@RequestMapping("/saveCustomer")
//	public String doSaveCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
//		customerService.save(customer);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "customer-list";
//	}
//	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public RedirectView save(@ModelAttribute("Customer") Customer customer, Model model,
			RedirectAttributes redirectAttrs) {
		customerService.save(customer);
		
		redirectAttrs.addAttribute("msg", "Hello World!");
		redirectAttrs.addFlashAttribute("name", customer.getName());
		redirectAttrs.addFlashAttribute("address", customer.getAddress());
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/hello/{msg}");
		
		
		return redirectView;
	}
//	
	@RequestMapping(value = "/hello/{msg}", method = RequestMethod.GET)
	public String hello(Model model, RedirectAttributes redirectAttrs, @PathVariable("msg") String msg,
			HttpServletRequest request) {
		
		System.out.println("Message:" + msg);
		System.out.println("Fetch Flash Attributes By using Model");
		System.out.println("Book Name:" + model.asMap().get("book"));
		System.out.println("Writer:" + model.asMap().get("writer"));
		
		return "redirect:/customer-list";
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
