package com.example.Something.effectiveJava.item1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {

	@PostMapping("/add")
	public LaptopDto addLaptop(@RequestBody LaptopForm laptopFrom) {
		// 입력 데이터는 postfix로 form을, API response는 postfix로 Dto를 사용

		// LaptopForm을 입력으로 받아서 새로운 Laptop 인스턴스를 만든다는게 명확하게 드러난다
		// from이나 of를 사용해야될 것 같은 경우는 예를 들어 제조사 type 파라미터 값에 따라 다른 제조사 정보를 가지는 Laptop 인스턴스를 만들어주는
		Laptop laptop = Laptop.from(laptopFrom);

	}
}
