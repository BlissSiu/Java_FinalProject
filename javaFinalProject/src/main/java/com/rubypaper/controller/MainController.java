package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/main")
	public String main(HttpSession session) {
		if(session.getId() != null) {
			return "main.html";
		}
		return "/login";
	}
	
	@GetMapping("/booking")
	public String booking() {
		return "booking.html";
	}
	
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
    	HttpSession session = req.getSession(false);
    	
    	if(session != null) {
    		session.invalidate();
    	}
    	
    	return "redirect:/login";
    }
}
