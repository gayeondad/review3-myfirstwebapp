package kr.co.bidworks.review3_myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("_SESSION")
public class WelcomeController {

	public WelcomeController() {
		super();
	}

	@GetMapping("/")
	public String showWelcomePage(ModelMap model) {
		model.addAttribute("_SESSION", "veronika");
		return "welcome";
	}

	// @GetMapping("/login")
	// public String showLoginPage() {
	// return "login";
	// }

}
