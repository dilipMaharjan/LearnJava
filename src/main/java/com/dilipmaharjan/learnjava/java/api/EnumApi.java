package com.dilipmaharjan.learnjava.java.api;

/**
 * Enum is used when we want to represent group of named constants
 * was introduced in java 1.5
 * semi-colon(;) is option
 * defines custom data type
 * default type of enum constants public static final
 * can be declared inside a class or outside but not inside a method
 * every enum is child of java.lang.Enum class and is final
 * inheritance concept is not applicable
 * example : enum WeekDays{SUNDAY,MONDAY,TUESDAY, ...,;}
 */
public class EnumApi {
    enum Days {
        SUN, MON, TUE
    }

    public static void main(String[] args) {
        Days days = Days.SUN;
        System.out.println(days);
        for (Days days1 : Days.values()) {
            if (days1.equals(Days.SUN)) {
                continue;
            }
            System.out.println(days1);
        }
    }
}
