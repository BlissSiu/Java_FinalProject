package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String joinMember(@ModelAttribute MemberDTO memberDTO, Model model) {
        try {
            memberService.registerMember(memberDTO);
            return "redirect:/login"; // 회원가입 성공 후 로그인
        } catch (IllegalArgumentException e) {
            // 중복된 아이디가 있는 경우 예외 처리
            model.addAttribute("errorMessage", e.getMessage());
            return "signup"; // 회원가입 페이지로 이동하여 에러 메시지 출력
        }
    }
	
    @GetMapping("/list")
    public List<Member> getMemberList() {
        return memberService.getMemberList();
    }
}
