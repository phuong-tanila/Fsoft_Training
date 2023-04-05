package fa.training.controller;

import fa.training.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("userSession")
public class UserController {

    @RequestMapping(value = {"/", "/addUser"}, method = RequestMethod.GET)
    public String doGetAddUser(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "add-user";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String doPostAddUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {

            return "add-user";
        }
        return "view-user";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(Model model) {
    	  System.out.println("UserController.login");
    	  
    	  model.addAttribute("user", new User());
        return "login";
    }
    
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model) {
    	  System.out.println("UserController.login");
    	  
    	  model.addAttribute("userSession", new User());
        return "add-user";
    }
    

    @RequestMapping(value = "/user/logoff", method = RequestMethod.GET)
    public String logoff() {
    	  System.out.println("UserController.logoff");
        return "logoff";
    }


}