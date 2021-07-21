package com.example.Something.sorting;

import com.example.Something.test.Dog;

import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.compareTo(o2);
	}
}
