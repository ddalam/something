package com.example.Something.mockito;

import java.util.Optional;

public interface StudyRepository {

	Optional<Study> findById(Long id);

	void validate(Long id);

}
