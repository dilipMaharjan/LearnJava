package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.tabulation;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(6));
        System.out.println(fibonacci.fib(7));
        System.out.println(fibonacci.fib(8));
        System.out.println(fibonacci.fib(50));
    }

    public int fib(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
