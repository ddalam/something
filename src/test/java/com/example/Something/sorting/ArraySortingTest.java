package com.example.Something.sorting;

import com.example.Something.test.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortingTest {

    @Test
    @DisplayName("Arrays를 사용한 int 배열 오름차순 정렬")
    void testIntArrayWithArraysAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {1, 4, 6, 19, 20, 99};
        int[] actual = arraySorting.sortIntArrayWithArraysAsc(new int[] {4, 19, 1, 20, 99, 6});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Arrays를 사용한 int 배열 일부분 오름차순 정렬")
    void testIntArrayPartWithArraysAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {1, 4, 19, 20, 99, 6};
        int[] actual = arraySorting.sortIntArrayWithArraysAsc(new int[] {4, 19, 1, 20, 99, 6}, 0, 3);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Arrays와 Lambda를 사용한 int 배열 오름차순 정렬")
    void testIntArrayWithArraysLambdaAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {1, 4, 6, 19, 20, 99};
        int[] actual = arraySorting.sortIntArrayWithArraysLambdaAsc(new int[] {4, 19, 1, 20, 99, 6});

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Arrays를 사용한 int 배열 내림차순 정렬")
    void testIntArrayWithArraysDescSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {99, 20, 19, 6, 4, 1};
        int[] actual = arraySorting.sortIntArrayWithArraysDesc(new int[] {4, 19, 1, 20, 99, 6});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Stream과 Lambda를 사용한 int 배열 오름차순 정렬")
    void testIntArrayPartWithStreamLambdaAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {1, 4, 6, 19, 20, 99};
        int[] actual = arraySorting.sortIntArrayWithStreamLambdaAsc(new int[] {4, 19, 1, 20, 99, 6});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Stream을 사용한 int 배열 내림차순 정렬")
    void testIntArrayWithStreamDescSorting() {
        ArraySorting arraySorting = new ArraySorting();

        int[] expected = {99, 20, 19, 6, 4, 1};
        int[] actual = arraySorting.sortIntArrayWithStreamDesc(new int[] {4, 19, 1, 20, 99, 6});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Arrays를 사용한 String 배열 오름차순 정렬")
    void testStringArrayWithArraysAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"apple", "banana", "melon", "orange"};
        String[] actual = arraySorting.sortStringArrayWithArraysAsc(new String[] {"apple", "orange", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Stream을 사용한 String 배열 오름차순 정렬")
    void testStringArrayWitStreamAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"apple", "banana", "melon", "orange"};
        String[] actual = arraySorting.sortStringArrayWithStreamAsc(new String[] {"apple", "orange", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Lambda를 사용해 String 배열을 문자열 길이 오름차순으로 정렬")
    void testStringArrayWitLambdaAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"melon", "banana", "apple333", "orange22"};
        String[] actual = arraySorting.sortStringArrayWithLambdaAsc(new String[] {"apple333", "orange22", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Arrays를 사용한 String 배열 내림차순 정렬")
    void testStringArrayWithArraysDescSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"orange", "melon", "banana", "apple"};
        String[] actual = arraySorting.sortStringArrayWithArraysDesc(new String[] {"apple", "orange", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Comparator를 사용한 String 배열 내림차순 정렬")
    void testStringArrayWithComparatorDescSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"orange", "melon", "banana", "apple"};
        String[] actual = arraySorting.sortStringArrayWithComparatorDesc(new String[] {"apple", "orange", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Stream과 Lambda를 사용한 String 배열 내림차순 정렬")
    void testStringArrayWithStreamLambdaDescSorting() {
        ArraySorting arraySorting = new ArraySorting();

        String[] expected = {"orange", "melon", "banana", "apple"};
        String[] actual = arraySorting.sortStringArrayWithStreamLambdaDesc(new String[] {"apple", "orange", "banana", "melon"});

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("클래스에 Comparable의 compareTo를 구현해 필드 값으로 오름차순 정렬")
    void testObjectArrayWithArraysAscSorting() {
        ArraySorting arraySorting = new ArraySorting();

        Dog[] expected = {
                new Dog("Bdog", 11.9F),
                new Dog("Adog", 20.3F),
                new Dog("Cdog", 99F)
        };
        Dog[] actual = arraySorting.sortObjectArrayWithArraysAsc(new Dog[] {
                                                                            new Dog("Bdog", 11.9F),
                                                                            new Dog("Cdog", 99F),
                                                                            new Dog("Adog", 20.3F)
                                                                    });

        assertEquals(expected[0].getWeight(), actual[0].getWeight());
        assertEquals(expected[1].getWeight(), actual[1].getWeight());
        assertEquals(expected[2].getWeight(), actual[2].getWeight());
    }
}