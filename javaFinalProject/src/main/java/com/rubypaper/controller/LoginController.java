package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.dto.LoginDTO;
import com.rubypaper.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm() {
			return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
        try {
            boolean loginSuccess = memberService.login(loginDTO, redirectAttributes);
            if (loginSuccess) {
                redirectAttributes.addFlashAttribute("message", "로그인 성공");
                return "redirect:/main";
            } else {
                redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
                return "redirect:/login";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "로그인 과정에서 오류가 발생했습니다.");
            return "redirect:/login";
        }
    }
}
