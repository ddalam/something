package com.example.Something.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

	@Test
	void createStudy() {

		// StudyRepository는 인터페이스로 StudyService를 생성하기 위해 구현체가 필요하다
		// Mockito.mock()을 사용하면 가짜 객체를 만들어준다
		StudyRepository studentRepository = mock(StudyRepository.class);

		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

	// 여러 메서드에서 mock 객체를 사용하고 싶을 때
	@Mock
	StudyRepository studentRepository;

	@Test
	void createStudy_2() {
		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

	// 특정 메서드에서 @Mock 애노테이션으로 mock 객체를 사용하고 싶을 때는 파라미터로 전달할 수 있다
	@Test
	void createStudy_3(@Mock StudyRepository studentRepository) {
		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

	@Test
	void createStudy_4(@Mock StudyRepository studentRepository) {
		StudyService studyService = new StudyService(studentRepository);

		// Optional 타입은 Optional.empty 리턴
		Optional<Study> optionalStudy = studyService.findStudy(1L);
		assertEquals(optionalStudy, Optional.empty());

		// void 메서드는 아무런 일도 일어나지 않는다
		studyService.validate(1L);

		assertNotNull(studyService);
	}

}