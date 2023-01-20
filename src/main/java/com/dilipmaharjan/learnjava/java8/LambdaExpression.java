package com.dilipmaharjan.learnjava.java8;

import java.util.function.BiConsumer;

public class LambdaExpression {
    /**
     * Functional programming functionality to object-oriented java
     * Concise code ( less code)
     * readability
     */
    public static void main(String[] args) {
        System.out.println("Lambda Expression");

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println("The of a and b is " + (a + b));
        biConsumer.accept(10, 5);
    }

}
