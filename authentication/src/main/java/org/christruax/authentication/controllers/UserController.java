package org.christruax.authentication.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.christruax.authentication.models.User;
import org.christruax.authentication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/registration/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/login/loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if (result.hasErrors()) {
			return "/registration/registrationPage.jsp";
		} else {
			User savedUser = userService.registerUser(user);
			session.setAttribute("userid", savedUser.getId());
			return "redirect:/home";
		}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	// List<String> errors = new ArrayList<String>();
    	if (userService.authenticateUser(email, password) == false) {
    		model.addAttribute("error", "Invalid Login");
			return "/login/loginPage.jsp";
		} else {
			User u = userService.findByEmail(email);
			session.setAttribute("userid", u.getId());
			return "redirect:/home";
		}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userid");
    	User user = userService.findUserById(userId);
    	model.addAttribute("user", user);
    	return "/home/homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
}
