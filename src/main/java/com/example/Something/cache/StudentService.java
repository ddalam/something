package com.example.Something.cache;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public void printStudent(String name) {
		Student student = studentRepository.getStudent(name);
		System.out.println("μ°Ύλ νμ : " + student);
	}

	@PostConstruct
	public void init() {
		studentRepository.enroll("jack", 15);
	}

}
