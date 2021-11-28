package com.example.Something.effectiveJava.item1;

import lombok.Getter;

@Getter
public class LaptopDto {

	private String modelName;
	private String companyName;

	// Entity를 Dto로 response 해야되는 경우에
	public static LaptopDto from(Laptop laptop) {
		LaptopDto laptopDto = new LaptopDto();
		laptopDto.modelName = laptop.getModelName();
		laptopDto.companyName = laptop.getCompanyName();
		return laptopDto;
	}

}
