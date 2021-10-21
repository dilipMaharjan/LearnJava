package com.dilipmaharjan.learnjava.java.api;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dilip
 */
public class DateUtil {
    public static void main(String[] args) {
        System.out.println(offsetDateTime());
        System.out.println(offsetDateTimeFormatted());
    }

    private static String offsetDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        return offsetDateTime.toString();
    }
    private static String offsetDateTimeFormatted() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:SSS'Z'");
        return offsetDateTime.format(formatter);
    }

}
