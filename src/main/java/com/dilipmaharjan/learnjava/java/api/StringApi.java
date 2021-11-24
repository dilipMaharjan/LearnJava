package com.dilipmaharjan.learnjava.java.api;

/**
 * @author Dilip
 */
public class StringApi {
    public static void main(String[] args) {
        System.out.println(paddedZeros(55555555));
        System.out.println(lastNStrings("00000078554884", 9));
    }

    private static String paddedZeros(long num) {
        String numb = String.valueOf(num);
        if (numb.length() < 9) {
            numb = String.format("%09d", num);
        }
        return numb;
    }

    private static String lastNStrings(String str, int n) {
        return str.substring(str.length() - n);
    }

    private static String paddedZeros(String str) {
        return str;
    }
}
