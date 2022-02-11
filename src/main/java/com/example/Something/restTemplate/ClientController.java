package com.example.Something.restTemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

	private final ClientService clientService;

	@GetMapping("")
	public UserResponse getHello() {
		return clientService.getRequest();
	}

}
