package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HowSum {


    public static void main(String[] args) {
        HowSum howSum = new HowSum();
        System.out.println(howSum.howSum(7, new int[]{2, 3}));
        System.out.println(howSum.howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum.howSum(7, new int[]{2, 4}));
        System.out.println(howSum.howSum(7, new int[]{2, 3, 5}));
//        System.out.println(howSum.howSum(300, new int[]{7, 14}));

        System.out.println("After Memoization");
        System.out.println(howSum.howSumWithMomoization(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(howSum.howSumWithMomoization(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(howSum.howSumWithMomoization(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(howSum.howSumWithMomoization(7, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(howSum.howSumWithMomoization(300, new int[]{7, 14}, new HashMap<>()));

    }

    ArrayList<Integer> howSum(int target, int[] array) {
        Map<Integer, ArrayList> map = new HashMap<>();

        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        for (int i : array) {
            int remainder = target - i;
            ArrayList<Integer> result = howSum(remainder, array);
            if (result != null) {
                result.add(i);
                map.put(target, result);
                return map.get(target);
            }
        }

        map.put(target, null);
        return null;
    }

    ArrayList<Integer> howSumWithMomoization(int target, int[] array, Map<Integer, ArrayList> memoizedMap) {
        if (memoizedMap.containsKey(target)) {
            return memoizedMap.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        for (int i : array) {
            int remainder = target - i;
            ArrayList<Integer> result = howSumWithMomoization(remainder, array, memoizedMap);
            if (result != null) {
                result.add(i);
                memoizedMap.put(target, result);
                return memoizedMap.get(target);
            }
        }
        memoizedMap.put(target, null);
        return null;
    }
}
