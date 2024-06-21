package com.rubypaper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Member {
	@Id
	@GeneratedValue
	public int seq;
	
	@NotNull
	 @Column(nullable = false, unique = true)
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phone;
	private String address;
	private String gender;
}


