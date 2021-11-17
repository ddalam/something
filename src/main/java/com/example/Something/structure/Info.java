package com.example.Something.structure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Info {

	private int year;

	@Override
	public String toString() {
		return "Info{" +
				"year=" + year +
				'}';
	}
}
