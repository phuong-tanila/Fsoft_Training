package fa.training.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fa.training.entities.Preferences;

@Controller
public class PreferencesControllor {
	private Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = { "/subscription" }, method = RequestMethod.GET)
	public String viewLogin(Model model) {
		ArrayList<String> interestList = new ArrayList<>();
		interestList.add("Quidditch");
		interestList.add("Herbology");
		interestList.add("Defence Against the Dark Arts");
		
		ArrayList<String> genderOptions = new ArrayList<>();
		genderOptions.add("Male");
		genderOptions.add("Female");
		
		ArrayList<String> skills = new ArrayList<>();
		skills.add("Java");
		skills.add("SQL Server");

		model.addAttribute("preferences", new Preferences());
		model.addAttribute("interestList", interestList);
		model.addAttribute("genderOptions", genderOptions);
		model.addAttribute("skills", skills);
		return "subscription";
	}

	@PostMapping("/subscription")
	public String subcription(@ModelAttribute("preferences") Preferences preferences, Model model) {
		logger.info(preferences);
		return "newsletter_subscription";
	}

}
