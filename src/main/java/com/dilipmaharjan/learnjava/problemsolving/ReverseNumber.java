package com.dilipmaharjan.learnjava.problemsolving;

import java.util.Scanner;

public class ReverseNumber {

    private static void reverseNumberUsingMathematics(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.printf("\nThe reversed num is %d\n", rev);
    }

    private static void reverseNumberUsingStringBuffer(int num) {
        System.out.printf("\nThe reversed num is %s\n", new StringBuffer(String.valueOf(num)).reverse());
    }

    private static void reverseNumberUsingStringBuilder(int num) {
        System.out.printf("\nThe reversed num is %s\n", new StringBuilder(String.valueOf(num))
                .reverse());
    }

    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("Input number %d", num);
        reverseNumberUsingMathematics(num);
        reverseNumberUsingStringBuffer(num);
        reverseNumberUsingStringBuilder(num);
    }
}
