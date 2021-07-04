package com.example.Something.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Example1 {

    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        int s = 0;
        for (int i = 1; i <= 100; i++) {
            iList.add(i);   // 리스트에 저장
        }

        s = iList.stream().reduce(0, Integer::sum);
        System.out.println("1~100의 합 : " + s);

        s = 0;
        s = iList.stream().filter(i -> i%2 == 1).reduce(0, Integer::sum);
        System.out.println("1~100 사이 홀수의 합: " + s);

        s = 0;
        s = iList.stream().filter(i -> i%2 == 1).reduce(0, (x,y) -> x+y);
        System.out.println("1~100 사이 홀수의 합: " + s);

        s = iList.stream().filter(i -> i%2 == 1).reduce(0,
                new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer t, Integer u) {
                        return t + u;
                    }
                });
        System.out.println("1~100 사이 홀수의 합: " + s);
    }
}
