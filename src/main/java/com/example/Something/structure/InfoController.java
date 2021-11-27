package com.example.Something.structure;

import java.util.ArrayList;
import java.util.List;
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

	@GetMapping("/infoList")
	public List<Info> getInfoList() {
		MonthlyInfo a = MonthlyInfo.builder()
				.year(10)
				.month(4)
				.build();

		MonthlyInfo b = MonthlyInfo.builder()
				.year(10)
				.month(4)
				.build();

		List<Info> c = new ArrayList<>();
		c.add(a);
		c.add(b);

		return c;
	}
}
