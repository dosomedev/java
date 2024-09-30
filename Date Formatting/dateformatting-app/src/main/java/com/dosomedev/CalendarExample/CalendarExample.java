package com.dosomedev.CalendarExample;

import java.util.Calendar;

public class CalendarExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Dates using Calendar class:");

        // Create Calendar object.
        Calendar calendar = Calendar.getInstance();
        
        // Print the date.
        String extractedDateA = convertCalendarToString(calendar);
        System.out.println("Current date and time:  " + extractedDateA);
        
        // Set a specific date.
        calendar.set(2021, Calendar.JANUARY, 10);
        
        // Print the date.
        String extractedDateB = convertCalendarToString(calendar);
        System.out.println("Specific date:          " + extractedDateB);
        
        // Add days.
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        
        // Print the date.
        String extractedDateC = convertCalendarToString(calendar);
        System.out.println("Specific date +10 days: " + extractedDateC);

        System.out.println();
    }

    private String convertCalendarToString(Calendar calendar) {
        // Extract date info.
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Month starts from 0.
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return String.format("%04d-%02d-%02d %02d:%02d:%02d",
            year, month, dayOfMonth, hourOfDay, minute, second);
    }
}
