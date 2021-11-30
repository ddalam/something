package com.example.Something.effectiveJava.item2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "hiddenBuilder")  // 필수값을 받지 않으면 생성하지 못하도록 제약할 수 있다
public class LombokNutritionFacts {

	private final int servingSize;  // 필수값
	private final int servings; // 필수값

	@Builder.Default
	private final int calories = 0;

	@Builder.Default
	private final int fat = 0;

	@Builder.Default
	private final int solium = 0;

	@Builder.Default
	private final int carbohydrate = 0;

//	public static NutritionFactsBuilder builder(int servingSize, int servings) {
//		return hiddenBuilder()
//				.servingSize(servingSize)
//				.servings(servings);
//	}

}
