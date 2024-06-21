package com.rubypaper.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rubypaper.Member;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO member (seq, id, pw, name, birth, phone, address, gender) VALUES ("
	        + "(select COALESCE(MAX(seq), 0) + 1 from member), "
	        + "#{id}, #{pw}, #{name}, #{birth}, #{phone}, #{address}, #{gender})"
	)
	public void insertMember(Member member);
	
    @Select("SELECT * FROM member ORDER BY seq DESC")
	public List<Member> getMemberList();
	
	
	
	

}
