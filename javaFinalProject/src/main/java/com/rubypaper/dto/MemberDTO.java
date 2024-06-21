package com.rubypaper.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberDTO {
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String id;
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    private String passwordConfirm;
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "필수 입력 값입니다.")
    private String gender;
    @NotBlank(message = "필수 입력 값입니다.")
    private String phone;
    @NotBlank(message = "필수 입력 값입니다.")
    private String year;
    @NotBlank(message = "필수 입력 값입니다.")
    private String month;
    @NotBlank(message = "필수 입력 값입니다.")
    private String day;
    @NotBlank(message = "필수 입력 값입니다.")
    private String address;

}
