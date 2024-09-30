package com.dosomedev.JavaTimeExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaTimeExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Dates using java.time package:");

        // Get current date and time.
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        // Print the dates.
        System.out.println("Local date:                            "
            + localDate);
        System.out.println("Local time:                            "
            + localTime);
        System.out.println("Local date and time:                   "
            + localDateTime);

        System.out.println("Local date formatted:                  "
            + localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Local time formatted:                  "
            + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Local date and time formatted:         "
            + localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        
        // Set a specific date.
        localDate = LocalDate.of(2022, 02, 22);
        localTime = LocalTime.of(12, 23, 51);
        localDateTime = LocalDateTime.of(2022, 02, 22, 12, 23, 51);
        
        // Print the dates.
        System.out.println("Local changed date:                    "
            + localDate);
        System.out.println("Local changed time:                    "
            + localTime);
        System.out.println("Local changed date and time:           "
            + localDateTime);
        
        System.out.println("Local changed date formatted:          "
            + localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Local changed time formatted:          "
            + localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Local changed date and time formatted: "
            + localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        
        // Add days, months, hours.
        LocalDate tomorrow = localDate.plusDays(1);
        LocalDate lastMonth = localDate.minusMonths(1);
        LocalTime oneHourLater = localTime.plusHours(1);
        LocalDateTime oneDayAgo = localDateTime.minusDays(1);
        
        // Print the dates.
        System.out.println("Tomorrow:                              "
            + tomorrow.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Last month:                            "
            + lastMonth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("One hour later:                        "
            + oneHourLater.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("One day ago:                           "
            + oneDayAgo.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        System.out.println();
    }
}
