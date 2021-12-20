package com.example.Something.cache;

import java.util.Map;
import javax.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class StudentRepository {

	private final Map<String, Student> storage;

	// 만약 여기가 병목이 일어나는 곳이라면
	@Cacheable("student")
	public Student getStudent(String name) {
		System.out.println("[repo] 나의 통행료는 무척 비싸다!");
		return storage.get(name);
	}

	public Student enroll(String name, Integer age) {
		return storage.put(name, Student.of(name, age));
	}
}
