package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    private final Map<String, BigInteger> map = new HashMap<>();

    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        System.out.println(gridTraveler.gridTraveler(1, 1));
        System.out.println(gridTraveler.gridTraveler(0, 0));
        System.out.println(gridTraveler.gridTraveler(2, 3));
        System.out.println(gridTraveler.gridTraveler(3, 2));
        System.out.println(gridTraveler.gridTraveler(3, 3));
//        System.out.println(gridTraveler.gridTraveler(181,181));

        System.out.println(gridTraveler.gridTravelerWithMemoization(1, 1));
        System.out.println(gridTraveler.gridTravelerWithMemoization(0, 0));
        System.out.println(gridTraveler.gridTravelerWithMemoization(2, 3));
        System.out.println(gridTraveler.gridTravelerWithMemoization(3, 2));
        System.out.println(gridTraveler.gridTravelerWithMemoization(3, 3));
        System.out.println("After Memoized");
        System.out.println(gridTraveler.gridTravelerWithMemoization(18, 18));


    }

    BigInteger gridTraveler(int row, int col) {

        if (row == 1 && col == 1) return BigInteger.ONE;
        if (row == 0 || col == 0) return BigInteger.ZERO;

        return gridTraveler(row - 1, col).add(gridTraveler(row, col - 1));
    }

    BigInteger gridTravelerWithMemoization(int row, int col) {
        if (row == 1 && col == 1) return BigInteger.ONE;
        if (row == 0 || col == 0) return BigInteger.ZERO;
        String memoizedValue = row + "," + col;
        if (map.containsKey(memoizedValue)) {
            return map.get(memoizedValue);
        }
        BigInteger result = gridTravelerWithMemoization(row - 1, col).add(gridTravelerWithMemoization(row, col - 1));
        map.put(memoizedValue, result);
        return map.get(memoizedValue);
    }
}
