package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.tabulation;

public class CanSum {
    public static void main(String[] args) {
        CanSum canSum = new CanSum();
        System.out.println(canSum.canSum(7, new int[]{2, 3}));
        System.out.println(canSum.canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum.canSum(7, new int[]{2, 4}));
        System.out.println(canSum.canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum.canSum(300, new int[]{7, 14}));
    }

    boolean canSum(int targetSum, int[] array) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;
        for (int i = 0; i <= targetSum; i++) {
            if (table[i]) {
                for (int arr : array) {
                    if (i + arr <= targetSum) {
                        table[i + arr] = true;
                    }
                }
            }
        }
        return table[targetSum];
    }
}
