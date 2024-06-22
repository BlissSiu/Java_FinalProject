package com.rubypaper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
<<<<<<< HEAD
import jakarta.persistence.GenerationType;
=======
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Member {
	@Id
<<<<<<< HEAD
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
	@GeneratedValue
>>>>>>> 86e4d4d17d7817123390cc2c137fb9eb8c7c296f
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


