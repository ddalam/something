package com.example.Something.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	private String name;
	private Integer age;

	public static Student of(String name, Integer age) {
		return Student.builder()
				.name(name)
				.age(age)
				.build();
	}
}
