package com.example.Something.mockito;

import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudyService {

	private final StudyRepository studentRepository;

	public Optional<Study> findStudy(Long id) {
		return studentRepository.findById(id);
	}

	public Study createStudy() {
		return new Study();
	}

	public void validate(Long id) {
		studentRepository.validate(id);
	}

}
