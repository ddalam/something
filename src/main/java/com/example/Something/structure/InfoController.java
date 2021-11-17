package com.example.Something.structure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoController {

	@GetMapping("/info")
	public String getInfo() {

//		Info a = new Info(3);
//		return a.toString();

		return MonthlyInfo.builder()
				.year(10)
				.month(4)
				.build().toString();
	}
}
