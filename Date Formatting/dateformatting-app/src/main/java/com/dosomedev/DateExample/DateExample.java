package com.dosomedev.DateExample;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Dates using Date class:");

        // Create Date object.
        Date currentDate = new Date();

        /*
         * Format Date using SimpledateFormat.
         * yyyy: Year with century.
         * MM:   Month (01-12).
         * dd:   Day of the month (01-31).
         * HH:   Hour in 24-hour format (00-23).
         * mm:   Minute (00-59).
         * ss:   Second (00-59).
         */
        SimpleDateFormat formatterA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterB = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterC = new SimpleDateFormat("HH:mm:ss");
        String formattedDateA = formatterA.format(currentDate);
        String formattedDateB = formatterB.format(currentDate);
        String formattedDateC = formatterC.format(currentDate);

        // Print the dates.
        System.out.println("Current date raw:           " + currentDate);
        System.out.println("Current date formatted (A): " + formattedDateA);
        System.out.println("Current date formatted (B): " + formattedDateB);
        System.out.println("Current date formatted (C): " + formattedDateC);

        System.out.println();
    }
}
