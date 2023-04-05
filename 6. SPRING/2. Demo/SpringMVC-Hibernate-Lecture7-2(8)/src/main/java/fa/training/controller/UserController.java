package fa.training.controller;

import fa.training.entities.Users;
import fa.training.service.UserService;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

//	@ModelAttribute
//	public void addAttributes(Model model) {
//		model.addAttribute("msg", "Welcome to Java Web class");
//
//	}

	@ModelAttribute("msg")
	public String addAttributes() {
		return "Welcome to Java Web class";

	}

	@ModelAttribute("user")
	public Users setUpUserForm() {
		return new Users();
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String viewLogin(Model model) {
		model.addAttribute("user", new Users());
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("user") Users user, HttpServletRequest request) {
		logger.debug("Start check login");
		Users userData = userService.checkLogin(user);
		logger.debug("End check login");

		if (userData != null) {
			request.getSession().setAttribute("username",userData.getUserName());
			return new ModelAndView("index", "username", userData.getUserName());
		} else {
			return new ModelAndView("login", "message", "Login Fail!");
		}
	}

	@GetMapping("/info")
	public String userInfo(@SessionAttribute("user") Users user) {
		System.out.println("User Name: " + user.getUserName());
		return "index";
	}

//	@GetMapping("/showViewPage")
//	public String passParametersWithModel(Model model) {
//		Map<String, String> map = new HashMap<>();
//		map.put("spring", "mvc");
//		model.addAttribute("message", "Welcome to Spring framework");
//		model.mergeAttributes(map);
//		return "viewPage";
//	}
//
//	@GetMapping("/showViewPage")
//	public String passParametersWithModelMap(ModelMap modelMap) {
//		modelMap.addAttribute("spring", "mvc");
//		modelMap.addAttribute("message", "Welcome to Spring framework");
//		return "viewPage";
//	}

	@GetMapping("/showViewPage")
	public ModelAndView passParametersWithModeAndView() {
		ModelAndView modelAndView = new ModelAndView("viewPage");
		modelAndView.addObject("spring", "mvc");
		modelAndView.addObject("message", "Welcome to Spring framework");
		return modelAndView;
	}

}
