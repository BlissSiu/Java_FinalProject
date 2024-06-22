package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.Member;
import com.rubypaper.dto.MemberDTO;
import com.rubypaper.persistance.MemberMapper;

@Service
public class MemberService {
	
    @Autowired
    private MemberMapper memberMapper;
	
    /*
    public void registerMember(MemberDTO memberDTO) {
        Member member = new Member();
        
        member.setId(memberDTO.getUsername());
        member.setPw(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        member.setGender(memberDTO.getGender());
        member.setPhone(memberDTO.getPhone());
        member.setAddress(memberDTO.getAddress());
        member.setBirth(memberDTO.getYear() +  memberDTO.getMonth() + memberDTO.getDay());
        

        memberMapper.insertMember(member);
    }
    */
    public void insertMember(Member member) {
    	memberMapper.save(member);
    }
	
    public List<Member> getMemberList() {
        return memberMapper.findAll();
    }
    
    public Member login(String email, String password) {
    	return memberMapper.findByIdAndPw(email, password);
    }

}
