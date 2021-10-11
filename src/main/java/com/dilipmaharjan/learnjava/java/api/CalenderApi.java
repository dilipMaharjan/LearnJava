package com.dilipmaharjan.learnjava.java.api;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderApi {
    private static final int CUT_OFF_TIME = 11;

    public static void main(String[] args) {
        exploreCalendarObject();

    }

    private static void exploreCalendarObject() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(" Calender Object : " + calendar);
        System.out.println("Timezone : " + calendar.getTimeZone());
        System.out.println("Timezone ID: " + calendar.getTimeZone().getID());
        System.out.println(" Year: " + calendar.get(Calendar.YEAR));
        System.out.println(" Month: " + calendar.get(Calendar.MONTH));
        System.out.println(" Date: " + calendar.get(Calendar.DATE));
        System.out.println("Time : " + calendar.getTime());
        System.out.println(" Hour: " + calendar.get(Calendar.HOUR));
        System.out.println(" Minute: " + calendar.get(Calendar.MINUTE));
        System.out.println(" Minute: " + calendar.get(Calendar.SECOND));
        add();
    }

    private static void add() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, 1);
        System.out.println("Day added: " + calendar.get(Calendar.DATE));
    }

    private static boolean cutOffTime(Calendar calendar) {
        if (CUT_OFF_TIME < calendar.get(Calendar.HOUR)) {
            return true;
        }
        return false;
    }
}
