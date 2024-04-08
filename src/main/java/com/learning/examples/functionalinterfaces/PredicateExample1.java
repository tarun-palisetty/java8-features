package com.learning.examples.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample1 {

    static Predicate<Integer> p1 = i -> i % 2 == 0;
    static Predicate<Integer> p2 = i -> i % 5 == 0;

    public static void main(String[] args) {

        testAnd();
        testOr();

        testNegate();

    }

    public static void testAnd() {

        System.out.println("----- Predicate And ------");
        System.out.println("Result from Predicate add: " + p1.and(p2).test(10));
    }

    public static void testOr() {
        System.out.println("\n----- Predicate Or ------");
        System.out.println("Result from Predicate or: " + p1.or(p2).test(15));
    }

    public static void testNegate() {
        System.out.println("\n-------Predicate Negate ------");
        System.out.println("Result from Predicate negate: " + p1.and(p2).negate().test(10));
    }
}
