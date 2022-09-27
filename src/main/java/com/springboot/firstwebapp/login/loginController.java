package com.springboot.firstwebapp.login;

import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
//	http://localhost:8080/login?name=john wick
//	@RequestMapping("login")
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		logger.debug("name mapped to html is {}",name);
//		model.put("name", name);
//		return "login";
//	}
	
//	@RequestMapping("login")
//	public String goToLoginPage() {
//		
//		return "login";
//	}
	
//	@RequestMapping(value="login",method=RequestMethod.GET)
//	public String goToLoginPage() {
//		return "login";
//	}
	
	private Authenticationservice auth;
	
	
	
	public loginController(Authenticationservice auth) {
		super();
		this.auth = auth;
	}



	@RequestMapping(value="login",method=RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name,@RequestParam String password ,ModelMap model) {
		
//		if(auth.authenticate(name, password)) {
//		model.put("name", name);
//		model.put("password", password);
//		return "Welcome";
//	}
//	
//		model.put("errorMessage", "wrong credentials");
	return "Welcome";
}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "Welcome";
	}
	
	private String getLoggedinUsername() {
		org.springframework.security.core.Authentication authentication
		=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
}