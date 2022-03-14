package com.example.Something.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

	@Test
	void test_1() {

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
	void test_2() {
		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

	// 특정 메서드에서 @Mock 애노테이션으로 mock 객체를 사용하고 싶을 때는 파라미터로 전달할 수 있다
	@Test
	void test_3(@Mock StudyRepository studentRepository) {
		StudyService studyService = new StudyService(studentRepository);

		assertNotNull(studyService);
	}

	// Mock 객체의 기본 행동
	@Test
	void test_4(@Mock StudyRepository studentRepository) {
		StudyService studyService = new StudyService(studentRepository);
		assertNotNull(studyService);

		// Optional 타입은 Optional.empty 리턴
		Optional<Study> optionalStudy = studyService.findStudy(1L);
		assertEquals(optionalStudy, Optional.empty());

		// void 메서드는 아무런 일도 일어나지 않는다
		studyService.validate(1L);
	}

	// Mock 객체가 어떤 행동을 해줬으면 좋겠다 -> 그렇게 동작하도록 만드는 것 -> stubbing
	@Test
	void test_5(@Mock StudyRepository studentRepository, @Mock MemberRepository memberRepository) {
		StudyService studyService = new StudyService(studentRepository, memberRepository);
		assertNotNull(studyService);

		Member member = new Member();
		member.setId(1L);
		member.setName("Kim");

		// stubbing 1
		when(memberRepository.findById(1L))      // memberRepository.findById(1L)가 호출되면
				.thenReturn(Optional.of(member));    // member를 리턴해라

		Study study = new Study();
		study.setId(1L);
		study.setName("Java");

		// ce
		studyService.createStudy(1L, study);
	}

}