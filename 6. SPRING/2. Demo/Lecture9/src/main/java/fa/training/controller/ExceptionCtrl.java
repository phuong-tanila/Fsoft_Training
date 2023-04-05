package fa.training.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fa.training.exception.MyException;
import fa.training.exception.ResourceNotFoundException;

@Controller
public class ExceptionCtrl {
	@RequestMapping(value = "/exception/{type}", method = RequestMethod.GET)
	public String exception(@PathVariable(name = "type") String exception) throws IOException {
		if (exception.equalsIgnoreCase("error")) {
			throw new MyException("A1001", "This is a custom exception message.");
		} else if (exception.equalsIgnoreCase("io-error")) {
			throw new IOException();
		} else if (exception.equalsIgnoreCase("404")) {
			throw new ResourceNotFoundException();
		} else {
			return "success";
		}
	}
}