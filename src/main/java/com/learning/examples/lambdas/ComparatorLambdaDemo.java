package com.learning.examples.lambdas;

import java.util.Comparator;

public class ComparatorLambdaDemo {

    public static void main(String[] args) {

        // Before Java8
        Comparator<Integer> comparatorInts = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Compare Integers 3 & 2 is: " + comparatorInts.compare(3, 2));

        // Comparator using lambda
        Comparator<Integer> comparatorLambda = (Integer int1, Integer int2) -> int1.compareTo(int2);
        System.out.println("Compare integers 3 & 2 using lambda: " + comparatorLambda.compare(3, 2));

        Comparator<Integer> comparatorLambda2 = Integer::compareTo;
        System.out.println("Compare integers 3 & 2 using lambda2: " + comparatorLambda.compare(3, 2));
    }
}
