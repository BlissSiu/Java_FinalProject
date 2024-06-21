package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.Member;
import com.rubypaper.dto.LoginDTO;
import com.rubypaper.dto.MemberDTO;
import com.rubypaper.persistance.MemberMapper;

@Service
public class MemberService {
	
    @Autowired
    private MemberMapper memberMapper;
    
    public boolean isUsernameExists(String id) {
        Member member = memberMapper.getMemberById(id);
        return member != null;
    }
	
    @Transactional
    public void registerMember(MemberDTO memberDTO) {
        if (isUsernameExists(memberDTO.getId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setPw(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        member.setGender(memberDTO.getGender());
        member.setPhone(memberDTO.getPhone());
        member.setAddress(memberDTO.getAddress());
        String birth = memberDTO.getYear() + memberDTO.getMonth() + memberDTO.getDay();
        member.setBirth(birth);

        memberMapper.insertMember(member);
    }
	
    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }
    
    public boolean login(@RequestBody LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
    	
    	Member member = memberMapper.getMemberById(loginDTO.getId());
    	
    	if (member != null && member.getPw().equals(loginDTO.getPw())) {
            // 로그인 성공
            redirectAttributes.addFlashAttribute("message", "로그인 성공");
            return true;
        } else {
            // 로그인 실패
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
    

}
