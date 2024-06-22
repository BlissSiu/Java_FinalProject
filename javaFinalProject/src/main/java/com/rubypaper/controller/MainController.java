package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubypaper.Member;
import com.rubypaper.persistance.MemberMapper;
import com.rubypaper.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String main(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session != null)
		{
			return "main.html";
		}
		
		return "login.html";
	}
	
	// 로그인 확인
	@PostMapping("/signin")
	public String login(@RequestParam String email,
						@RequestParam String password,
						HttpServletRequest req,
						Model model) {
		Member member = memberService.login(email, password);
		// 로그인 성공
		if(member != null) {
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			return "redirect:/main";
		}
		else {
			return "redirect:/login";
		}
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/logout";
	}
}
