package com.dilipmaharjan.learnjava.problemsolving;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Enter a string to reverse.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        revStringUsingStrConcatenation(str);
        revStringUsingCharacterArray(str);
        revStringUsingStringBuffer(str);
        revStringUsingStringBuilder(str);

    }

    private static void revStringUsingStrConcatenation(String str) {
        String rev = "";
        int len = str.length();

        for (int i = len - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }

    private static void revStringUsingCharacterArray(String str) {
        String rev = "";
        int len = str.length();
        char[] chars = str.toCharArray();

        for (int i = len - 1; i >= 0; i--) {
            rev = rev + chars[i];
        }
        System.out.println(rev);
    }

    private static void revStringUsingStringBuffer(String str) {
        System.out.println(new StringBuffer(str).reverse());
    }
    private static void revStringUsingStringBuilder(String str) {
        System.out.println(new StringBuilder(str).reverse());
    }

}
