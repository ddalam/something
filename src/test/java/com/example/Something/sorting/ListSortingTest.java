package com.example.Something.sorting;

import com.example.Something.test.Dog;
import com.example.Something.test.Dog2;
import org.hibernate.mapping.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListSortingTest {

	@Test
    @DisplayName("Collections.sort()를 사용해 객체의 무게로 오름차순 정렬")
    void testListAscSortingWithCollections_ver1() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("B", 99.4F));
	    dogList.add(new Dog("C", 100F));
        dogList.add(new Dog("A", 11.2F));

        Collections.sort(dogList);

    }

    @Test
    @DisplayName("Collections.sort()를 사용해 객체의 이름으로 오름차순 정렬")
    void testListAscSortingWithCollections_ver2() {

        List<Dog2> dogList = new ArrayList();
        dogList.add(new Dog2("B", 99.4F));
	    dogList.add(new Dog2("C", 100F));
        dogList.add(new Dog2("A", 11.2F));

        Collections.sort(dogList, new Comparator<Dog2>() {
			@Override
			public int compare(Dog2 o1, Dog2 o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

    }

    @Test
    @DisplayName("Collections.sort()를 사용해 객체의 이름으로 오름차순 정렬 - 대소문자 구분없이")
    void testListAscSortingWithCollections_ver3() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("Buddy", 99.4F));
	    dogList.add(new Dog("caca", 100F));
        dogList.add(new Dog("babu", 11.2F));

        // TODO
//        Collections.sort(dogList, );

    }

    @Test
    @DisplayName("외부에 구현한 커스텀 comparator를 사용해 객체의 이름으로 오름차순 정렬 - 대소문자 구분없이")
    void testListAscSortingWithCollections_ver4() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("Buddy", 99.4F));
	    dogList.add(new Dog("caca", 100F));
        dogList.add(new Dog("babu", 11.2F));

        Collections.sort(dogList, new DogNameComparator());

    }

    @Test
    @DisplayName("Collections.sort()를 사용해 객체의 무게로 내림차순 정렬")
    void testListDescSortingWithCollections_ver1() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("B", 99.4F));
	    dogList.add(new Dog("C", 100F));
        dogList.add(new Dog("A", 11.2F));

        // Dog에는 오름차순으로 정렬하는 compareTo() 메서드가 정의되어 있는데, 이렇게하면 내림차순 정렬이 된다
        Collections.sort(dogList, Collections.reverseOrder());

    }

    @Test
    @DisplayName("외부에 구현한 커스텀 comparator를 사용해 객체의 이름으로 오름차순 정렬 - 대소문자 구분없이")
    void testListDescSortingWithCollections_ver2() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("Buddy", 99.4F));
	    dogList.add(new Dog("caca", 100F));
        dogList.add(new Dog("babu", 11.2F));

        Collections.sort(dogList, new DogNameComparator().reversed());

    }

    @Test
    @DisplayName("List.sort()를 사용해 객체의 무게로 오름차순 정렬")
    void testListAscSortingWithList_ver1() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("B", 99.4F));
	    dogList.add(new Dog("C", 100F));
        dogList.add(new Dog("A", 11.2F));

        dogList.sort(Comparator.naturalOrder());

    }

    @Test
    @DisplayName("List.sort()를 사용해 객체의 이름으로 내림차순 정렬")
    void testListDescSortingWithList_ver1() {

        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("B", 99.4F));
	    dogList.add(new Dog("C", 100F));
        dogList.add(new Dog("A", 11.2F));

		dogList.sort(Collections.reverseOrder());

    }

}
