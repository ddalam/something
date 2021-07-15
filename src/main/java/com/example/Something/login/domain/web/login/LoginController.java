package com.example.Something.login.domain.web.login;

import com.example.Something.login.domain.login.LoginService;
import com.example.Something.login.domain.member.Member;
import com.example.Something.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	private final MemberRepository memberRepository;

	@PostMapping("/login")
	public String login(@Valid @RequestBody LoginForm loginForm) {

		Member newMember = new Member();
		newMember.setLoginId(loginForm.getLoginId());
		newMember.setPassword(loginForm.getPassword());
		newMember.setName("aaaa");
		memberRepository.save(newMember);

		Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

		if (loginMember == null) {
			return "아이디 또는 비밀번호가 맞지 않습니다";
		}

		// TODO 로그인 성공 처리
		return "로그인 성공";
	}
}
