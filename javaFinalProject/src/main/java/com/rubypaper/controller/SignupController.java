package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.Member;
import com.rubypaper.dto.MemberDTO;
import com.rubypaper.service.MemberService;


@Controller
public class SignupController {
	
	@Autowired
    private MemberService memberService;
	
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/join")
	public String joinMember(@ModelAttribute Member member) {
		memberService.insertMember(member);
		
		 return "redirect:/signup";
	}
	
    @GetMapping("/list")
    public List<Member> getMemberList() {
        return memberService.getMemberList();
    }
}
