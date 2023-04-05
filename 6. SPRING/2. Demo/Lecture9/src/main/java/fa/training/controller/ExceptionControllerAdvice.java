package fa.training.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import fa.training.exception.MyException;
import fa.training.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(MyException.class)
	public ModelAndView handleMyException(MyException mex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errCode", mex.getErrCode());
		model.addObject("errMsg", mex.getErrMsg());
		model.setViewName("error/generic_error");
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errMsg", "This is a 'Exception.class' message.");
		model.setViewName("error/generic_error");
		return model;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException() {
		return "notFoundJSPPage";
	}
}