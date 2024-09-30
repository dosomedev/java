package com.dosomedev.OtherCalendarExample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OtherCalendarExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Date in other calendars:");

        // Gregorian Calendar.
        LocalDate gregorianDate = LocalDate.of(2024, 9, 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String gregorianDateString = gregorianDate.format(formatter);
        System.out.println("Christian / Gregorian Date: " + gregorianDateString);
        
        // Jewish Calendar.
        JewishCalendar jewishCalendar = new JewishCalendar();
        String jewishDateString = jewishCalendar.getJewishDate(gregorianDate);
        System.out.println("Jewish / Hebrew Date:       " + jewishDateString);
        
        // Muslim Calendar.
        MuslimCalendar muslimCalendar = new MuslimCalendar();
        String muslimDateString = muslimCalendar.getMuslimDate(gregorianDate);
        System.out.println("Muslim / Hijri Date:        " + muslimDateString);

        System.out.println();
    }
}
