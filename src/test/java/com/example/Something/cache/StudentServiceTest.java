package com.example.Something.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	StudentService studentService;

	@Test
	void init() {
		studentService.printStudent("jack");
		studentService.printStudent("jack");
		studentService.printStudent("jack");
		studentService.printStudent("fred");
		studentService.printStudent("cassie");
		studentService.printStudent("cassie");
	}

}