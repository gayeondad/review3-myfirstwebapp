package kr.co.bidworks.review3_myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("_SESSION")
public class LoginController {

	private AuthenticateService authenticateService;

	public LoginController(AuthenticateService authenticateService) {
		super();
		this.authenticateService = authenticateService;
	}

	@GetMapping("/login")
	public String goLoginPage(@RequestParam("username") String name, ModelMap model) {
		model.put("username", name);
		return "login";
	}

	@PostMapping("/login")
	public String authenticateLogin(@RequestParam("uname") String name, @RequestParam("upwd") String password,
			ModelMap model) {
		if (authenticateService.authenticate(name, password)) {
			model.put("_SESSION", name);
			return "welcome";
		}
		return "login";
	}

	@GetMapping("/welcome")
	public String goWelcomePage() {
		return "welcome";
	}

	@GetMapping("/logout")
	public String goLogoutPage(ModelMap model) {
//		model.getAttribute("_SESSION");
//		model.remove("_SESSION");
		model.clear();
		return "redirect:/";
	}

}
