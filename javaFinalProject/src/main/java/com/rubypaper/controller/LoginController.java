package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.dto.LoginDTO;
import com.rubypaper.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession session, RedirectAttributes redirectAttributes) {
    	
        try {
            // 로그인 서비스 호출
            boolean loginSuccess = memberService.login(loginDTO, redirectAttributes, session);
            if (loginSuccess) {
                redirectAttributes.addFlashAttribute("message", "로그인 성공");
                return "redirect:/main"; // main 페이지로 리다이렉트
            } else {
                redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
                return "redirect:/login"; // 로그인 실패 시 로그인 페이지로 리다이렉트
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "로그인 과정에서 오류가 발생했습니다.");
            return "redirect:/login"; // 예외 발생 시 로그인 페이지로 리다이렉트
        }
    }
}