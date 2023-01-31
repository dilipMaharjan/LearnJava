package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    private final Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        CanSum canSum = new CanSum();
        System.out.println(canSum.canSum(7, new int[]{2, 3}));
        System.out.println(canSum.canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum.canSum(7, new int[]{2, 4}));
        System.out.println(canSum.canSum(7, new int[]{2, 3, 5}));
        System.out.println(canSum.canSum(300, new int[]{7, 14}));

        System.out.println("After Memoization");

        System.out.println(canSum.canSumWithMomoization(7, new int[]{2, 3}));
        System.out.println(canSum.canSumWithMomoization(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum.canSumWithMomoization(7, new int[]{2, 4}));
        System.out.println(canSum.canSumWithMomoization(7, new int[]{2, 3, 5}));
        System.out.println(canSum.canSumWithMomoization(300, new int[]{7, 14}));

    }

    boolean canSum(int target, int[] array) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int remainder = target - array[i];
            if (canSum(remainder, array)) {
                return true;
            }
        }
        return false;
    }

    boolean canSumWithMomoization(int target, int[] array) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int remainder = target - array[i];
            if (canSumWithMomoization(remainder, array)) {
                map.put(target, true);
                return true;
            }
        }
        map.put(target, false);
        return false;
    }
}
