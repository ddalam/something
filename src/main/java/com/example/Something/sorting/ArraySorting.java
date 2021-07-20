package com.example.Something.sorting;

import com.example.Something.test.Dog;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class ArraySorting {

    public static int[] sortIntArrayWithArraysAsc(int[] intArray) {
        Arrays.sort(intArray);
        return intArray;
    }

    public int[] sortIntArrayWithArraysAsc(int[] intArray, int startIndex, int endIndex) {
        Arrays.sort(intArray, startIndex, endIndex);
        return intArray;
    }

    public int[] sortIntArrayWithArraysLambdaAsc(int[] intArray) {
        Integer[] arr = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> o1.compareTo(o2));
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }

    public int[] sortIntArrayWithStreamLambdaAsc(int[] intArray) {
        Integer[] arr = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Integer[] sortedArr = Stream.of(arr).sorted((o1,o2) -> o1.compareTo(o2)).toArray(Integer[]::new);
        return Arrays.stream(sortedArr).mapToInt(i -> i).toArray();
    }

    public int[] sortIntArrayWithArraysDesc(int[] intArray) {
        Integer[] arr = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        // Collections.reverseOrder() or Comparator.reverseOrder()
        Arrays.sort(arr, Collections.reverseOrder());
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }

    public int[] sortIntArrayWithArraysDesc(int[] intArray, int startIndex, int endIndex) {
        Integer[] arr = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        // Collections.reverseOrder() or Comparator.reverseOrder()
        Arrays.sort(arr, startIndex, endIndex, Collections.reverseOrder());
        return Arrays.stream(arr).mapToInt(i -> i).toArray();
    }

    public int[] sortIntArrayWithStreamDesc(int[] intArray) {
        Integer[] arr = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Integer[] sortedArr = Stream.of(arr).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        return Arrays.stream(sortedArr).mapToInt(i -> i).toArray();
    }

    public String[] sortStringArrayWithArraysAsc(String[] stringArray) {
        Arrays.sort(stringArray);
        return stringArray;
    }

    public String[] sortStringArrayWithStreamAsc(String[] stringArray) {
        return Stream.of(stringArray).sorted().toArray(String[]::new);
    }

    public String[] sortStringArrayWithLambdaAsc(String[] stringArray) {
        Arrays.sort(stringArray, (s1, s2) -> s1.length() - s2.length());
        return stringArray;
    }

    public String[] sortStringArrayWithArraysDesc(String[] stringArray) {
        // Collections.reverseOrder() or Comparator.reverseOrder()
        Arrays.sort(stringArray, Comparator.reverseOrder());
        return stringArray;
    }

    public String[] sortStringArrayWithComparatorDesc(String[] stringArray) {
        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return stringArray;
    }

    public String[] sortStringArrayWithStreamLambdaDesc(String[] stringArray) {
        return Stream.of(stringArray).sorted((o1,o2) -> o2.compareTo(o1)).toArray(String[]::new);
    }

    public Dog[] sortObjectArrayWithArraysAsc(Dog[] dogs) {
        Arrays.sort(dogs);
        return dogs;
    }
}
