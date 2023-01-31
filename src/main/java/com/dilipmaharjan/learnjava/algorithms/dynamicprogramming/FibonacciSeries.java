package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {
    private final Map<Integer, Integer> memoizationMap = new HashMap<>();

    public static void main(String[] args) {

        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        System.out.println(fibonacciSeries.fibo(6));
        System.out.println(fibonacciSeries.fiboWithMemoization(60));
    }

    /**
     * @param n
     * @return the nth fibonacci number
     */
    int fibo(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    /**
     * The problem with above solution is as the n grows the time taken to resolve the problem is 2*n
     * The time complexity can be reduced to n by using dynamic programming concept called memoization
     * Memoization is basically a technique to store solution to smaller problem and use it later.
     *
     * @param n
     * @return nth fibonacci number
     */
    int fiboWithMemoization(int n) {
        //Base case
        if (n <= 2) {
            return 1;
        }

        // check if the problem is already resolved

        if (memoizationMap.containsKey(n)) {
            return memoizationMap.get(n);
        }

        int result = fiboWithMemoization(n - 1) + fiboWithMemoization(n - 2);

        //store the solution to smaller problem
        memoizationMap.put(n, result);
        return result;
    }
}
