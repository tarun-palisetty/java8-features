package com.learning.examples.functionalinterfaces;

import java.util.function.BiConsumer;

public class BiConsumerExample2 {

    static BiConsumer<Integer, Integer> add = (a, b) -> System.out.println(a + b);
    static BiConsumer<Integer, Integer> subtraction = (a, b) -> System.out.println(a - b);

    public static void main(String[] args) {

        // Call biConsumer
        add.accept(1, 2);
        subtraction.accept(5, 1);

        // consumer chaining
        System.out.println("\n---------- BiConsumer chaining ------------");
        add.andThen(subtraction).accept(5, 1);
    }
}
