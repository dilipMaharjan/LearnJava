package com.dilipmaharjan.learnjava.algorithms.dynamicprogramming.tabulation;

public class GridTraveler {
    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        System.out.println(gridTraveler.gridTraveler(1, 1));
        System.out.println(gridTraveler.gridTraveler(2, 3));
        System.out.println(gridTraveler.gridTraveler(3, 3));
        System.out.println(gridTraveler.gridTraveler(18, 18));
    }

    private int gridTraveler(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        table[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = table[i][j];
                if (i + 1 <= m)
                    table[i + 1][j] += current;
                if (j + 1 <= n)
                    table[i][j + 1] += current;
            }
        }
        return table[m][n];
    }
}
