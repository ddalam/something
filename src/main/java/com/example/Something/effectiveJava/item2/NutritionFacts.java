package com.example.Something.effectiveJava.item2;

import lombok.Getter;

@Getter
public class NutritionFacts {

	private final int servingSize;
	private final int servings;
	private final int calories;

	public static class Builder {
		private final int servingSize;
		private final int servings;
		private int calories = 0;

		public Builder(int servingSize, int servings) { // Builder의 생성자로 필수 요소들을 주입
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {  // 필수요소가 아닌 값들은 Builder 체인으로 추가
			calories = val;
			return this;  // Builder 자신을 반환하기 때문에 연쇄적으로 호출할 수 있다
		}

		public NutritionFacts build() { // 더 이상 추가할 값이 없을 때는 새로운 객체를 response
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
	}

}
