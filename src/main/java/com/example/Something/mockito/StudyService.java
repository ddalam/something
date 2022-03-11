package com.example.Something.mockito;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudyService {

	private final StudyRepository studentRepository;

	public Study createStudy() {
		return new Study();
	}

}
