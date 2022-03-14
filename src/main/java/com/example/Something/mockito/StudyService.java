package com.example.Something.mockito;

import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudyService {

	private final StudyRepository studentRepository;
	private final MemberRepository memberRepository;

	public Optional<Study> findStudy(Long id) {
		return studentRepository.findById(id);
	}

	public Study createStudy(Long memberId, Study study) {
		Optional<Member> member = memberRepository.findById(memberId);
		study.setOwner(member.orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다.")));
		return studentRepository.save(study);
	}

	public void validate(Long id) {
		studentRepository.validate(id);
	}

}
