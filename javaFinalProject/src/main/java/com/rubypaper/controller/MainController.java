<<<<<<< HEAD
package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main.html";
	}
	
	@GetMapping("/booking")
	public String booking() {
		return "booking.html";
	}
	
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
=======
package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main.html";
	}
}
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
