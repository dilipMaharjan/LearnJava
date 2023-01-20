package com.dilipmaharjan.learnjava.java8;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    static void div(int a, int b) {
        System.out.println(a / b);
    }

    /**
     * interface with only one abstract method
     * can have multiple default and static methods
     */
    public void sayHello();

    default void sub(int a, int b) {
        System.out.println(a - b);
    }

    default void mult(int a, int b) {
        System.out.println(a * b);
    }
}
