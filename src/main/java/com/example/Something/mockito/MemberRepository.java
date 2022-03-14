package com.example.Something.mockito;

import java.util.Optional;

public interface MemberRepository {

	Optional<Member> findById(Long id);

}
