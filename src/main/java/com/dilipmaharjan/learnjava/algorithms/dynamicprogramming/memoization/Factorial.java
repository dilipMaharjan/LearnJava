package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Factorial {
    private final Map<BigInteger, BigInteger> map = new HashMap<>();

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(BigInteger.valueOf(1000)));
        System.out.println(factorial.factorialWithMomoization(BigInteger.valueOf(1000)));

    }

    BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == -1) {
            return BigInteger.ONE;
        }
        if (n.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }

    BigInteger factorialWithMomoization(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == -1) {
            return BigInteger.ONE;
        }
        if (n.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        BigInteger result = n.multiply(factorialWithMomoization(n.subtract(BigInteger.ONE)));
        map.put(n, result);
        return result;
    }
}
