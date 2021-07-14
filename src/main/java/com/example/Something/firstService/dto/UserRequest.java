package com.example.Something.firstService.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // 이 객체를 JSON 응답으로 줄 때 어떤 값들을 응답에 포함시킬건지 정해줄 수 있다
public class UserRequest {

	private String name;
	private String email;
	private int age;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
