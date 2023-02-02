package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        BestSum bestSum = new BestSum();
        System.out.println(bestSum.bestSum(7, new int[]{5, 4, 3, 7}));
        System.out.println(bestSum.bestSum(8, new int[]{2, 3, 5}));
        System.out.println(bestSum.bestSum(8, new int[]{1, 4, 5}));
//        System.out.println(bestSum.bestSum(100, new int[]{1, 2, 5, 25}));
        System.out.println("After Memoization");
        System.out.println(bestSum.bestSumMemoized(7, new int[]{5, 4, 3, 7}, new HashMap<>()));
        System.out.println(bestSum.bestSumMemoized(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(bestSum.bestSumMemoized(8, new int[]{1, 4, 5}, new HashMap<>()));
        System.out.println(bestSum.bestSumMemoized(100, new int[]{1, 2, 5, 25}, new HashMap<>()));

    }

    ArrayList<Integer> bestSum(int target, int[] numbers) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> shortestCombination = null;
        for (int num : numbers) {
            int remainder = target - num;
            ArrayList<Integer> remainderCombination = bestSum(remainder, numbers);
            if (null != remainderCombination) {
                ArrayList<Integer> combination = remainderCombination;
                combination.add(num);
                if (null == shortestCombination || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        return shortestCombination;
    }

    ArrayList<Integer> bestSumMemoized(int target, int[] numbers, Map<Integer, ArrayList> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> shortestCombination = null;
        for (int num : numbers) {
            int remainder = target - num;
            ArrayList<Integer> remainderCombination = bestSumMemoized(remainder, numbers, map);
            if (null != remainderCombination) {
                ArrayList<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(num);
                if (null == shortestCombination || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        map.put(target, shortestCombination);
        return shortestCombination;
    }
}
