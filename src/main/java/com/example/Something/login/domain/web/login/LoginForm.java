package com.example.Something.login.domain.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

	@NotEmpty
	private String loginId;

	@NotEmpty
	private String password;
}
