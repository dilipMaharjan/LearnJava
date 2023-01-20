package com.dilipmaharjan.learnjava.java8;

public class MethodReference {
    public static void main(String[] args) {
        FunctionalInterface sayHello = MethodReferrenceExample::sayHello;
        sayHello.sayHello();
    }

}

class MethodReferrenceExample {
    public static void sayHello() {
        System.out.println("Hello");
    }
}