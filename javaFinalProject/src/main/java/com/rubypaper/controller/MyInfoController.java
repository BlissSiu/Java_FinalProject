package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.Member;
import com.rubypaper.persistance.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyInfoController {

    @Autowired
    private MemberMapper memberMapper; // MemberMapper 인터페이스를 주입 받음

    @GetMapping("/myInfo")
    public String myInfo(Model model, HttpSession session) {
        // 세션에서 사용자 ID를 가져옴
        String userId = (String) session.getAttribute("userId");

        // 사용자 ID를 기반으로 Member 정보를 조회
        Member member = memberMapper.getMemberById(userId);

        // 조회된 Member 객체를 모델에 추가하여 뷰로 전달
        model.addAttribute("member", member);

        return "myInfo"; // 뷰 이름 반환 (myInfo.html)
    }
    
    @PostMapping("/updateName")
    public String updateName(@RequestParam("name") String name, HttpSession session, RedirectAttributes redirectAttributes) {
        // 세션에서 사용자 ID를 가져옴
        String userId = (String) session.getAttribute("userId");

        // 사용자 ID를 기반으로 Member 정보를 조회
        Member member = memberMapper.getMemberById(userId);
        
        // Member 객체의 이름 수정
        member.setName(name);
        
        // Member 정보 업데이트
        memberMapper.updateMember(member);
        
        session.setAttribute("username", member.getName());
        
        // 사용자에게 메시지 전달
        redirectAttributes.addFlashAttribute("message", "이름이 성공적으로 수정되었습니다.");

        return "redirect:/myInfo"; // myInfo 페이지로 리다이렉트
    }
    
}