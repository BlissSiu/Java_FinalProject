package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.Member;
import com.rubypaper.dto.LoginDTO;
import com.rubypaper.dto.MemberDTO;
import com.rubypaper.persistance.MemberMapper;

<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

=======
@Service
public class MemberService {
	
    @Autowired
    private MemberMapper memberMapper;
    
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
    public boolean isUsernameExists(String id) {
        Member member = memberMapper.getMemberById(id);
        return member != null;
    }
<<<<<<< HEAD

=======
	
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
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
<<<<<<< HEAD

    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    public boolean login(LoginDTO loginDTO, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Member member = memberMapper.getMemberById(loginDTO.getId());

        if (member != null && member.getPw().equals(loginDTO.getPw())) {
            // 로그인 성공 시 세션에 사용자 이름 저장
            HttpSession session = request.getSession();
            session.setAttribute("username", member.getName());
            session.setAttribute("userId", member.getId());
=======
	
    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }
    
    public boolean login(@RequestBody LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
    	
    	Member member = memberMapper.getMemberById(loginDTO.getId());
    	
    	if (member != null && member.getPw().equals(loginDTO.getPw())) {
            // 로그인 성공
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
            redirectAttributes.addFlashAttribute("message", "로그인 성공");
            return true;
        } else {
            // 로그인 실패
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
<<<<<<< HEAD
=======
    

>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
}
