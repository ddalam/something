package com.example.Something.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class StudyServiceTest {

	@Test
	void createStudy() {

		// StudyRepository는 인터페이스로 StudyService를 생성하기 위해 구현체가 필요하다
		// Mockito.mock()을 사용하면 가짜 객체를 만들어준다
		StudyRepository studentRepository = mock(StudyRepository.class);

		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

}