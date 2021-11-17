package com.example.Something.structure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@GetMapping("/api/info")
	public Info getInfo() {
		return new MonthlyInfo();
	}
}
