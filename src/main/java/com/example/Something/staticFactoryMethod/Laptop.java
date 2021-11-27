package com.example.Something.staticFactoryMethod;

import lombok.Getter;

// Entity

@Getter
public class Laptop {

	private Long id;
	private String modelName;
	private String companyName;

	public static Laptop from(LaptopForm laptopForm) {
		// LaptopForm에서 get() 메서드 호출로 새로운 객체를 만드는데 항목이 15개 이상으로 늘어난다면 무의미해 보이는 15줄의 코드가 생긴다 이런 코드가 여러군데에 생길수도 있다
		Laptop laptop = new Laptop();
		laptop.modelName = laptopForm.getModelName();
		laptop.companyName = laptopForm.getCompany();
		return laptop;
	}

	// 이름을 가진 static factory method
	// 생성자는 어느 순서로 파라미터를 전달해야할지 명확히 알기 어렵다(IDE가 지원하지만)
	// 파라미터가 많아지면 메서드명에 다 나열하기는 어렵지만, 중요한 정보를 메서드명에 명시해줄 수 있다
	public static Laptop ofModelNameAndCompany(String modelName, String companyName) {
		Laptop laptop = new Laptop();
		laptop.modelName = modelName;
		laptop.company = companyName;
		return laptop;
	}
}
