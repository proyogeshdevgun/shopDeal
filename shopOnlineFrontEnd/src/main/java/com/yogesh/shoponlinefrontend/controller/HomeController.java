package com.yogesh.shoponlinefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogesh.shoponlineback.dao.UserDAO;
import com.yogesh.shoponlineback.model.User;

@Controller
public class HomeController {

	
	@Autowired
	UserDAO userDAO;


	@RequestMapping("/")
	public String homePage() {
		System.out.println("Executing  the method homePage");
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView showLoginPage() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "You clicked login link");
		mv.addObject("showLoginPage", "true");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("msg", "You clicked Registration link ");

		mv.addObject("showRegistrationPage", "true");

		return mv;
	}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd) {
		System.out.println("In validate method");
		System.out.println("id: " + id);
		System.out.println("pwd: " + pwd);
		ModelAndView mv = new ModelAndView("home");

		if (userDAO.validate(id, pwd) != null) {
			mv.addObject("successMsg", "You logged in successfully");
		} else {
			mv.addObject("errorMsg", "Invalid Credentials..Please try again");
		}

		return mv;
	}

}
