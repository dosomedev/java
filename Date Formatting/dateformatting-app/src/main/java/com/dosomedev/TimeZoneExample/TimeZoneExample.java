package com.dosomedev.TimeZoneExample;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZoneExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Dates of different time zones:");

        // Get UTC time.
        Instant now = Instant.now();
        System.out.println("Now:                 " + now);
        
        // Create time zones.
        ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");
        ZoneId rioZoneId = ZoneId.of("America/Sao_Paulo");
        ZoneId londonZoneId = ZoneId.of("Europe/London");
        ZoneId mumbaiZoneId = ZoneId.of("Asia/Kolkata");
        ZoneId tokioZoneId = ZoneId.of("Asia/Tokyo");
        ZoneId sydneyZoneId = ZoneId.of("Australia/Sydney");
        
        // Convert UTC time to time zones.
        LocalDateTime losAngelesTime = now.atZone(losAngelesZoneId).toLocalDateTime();
        LocalDateTime rioTime = now.atZone(rioZoneId).toLocalDateTime();
        LocalDateTime londonTime = now.atZone(londonZoneId).toLocalDateTime();
        LocalDateTime mumbaiTime = now.atZone(mumbaiZoneId).toLocalDateTime();
        LocalDateTime tokioTime = now.atZone(tokioZoneId).toLocalDateTime();
        LocalDateTime sydneyTime = now.atZone(sydneyZoneId).toLocalDateTime();
        
        // Format date.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        
        // Print times.
        System.out.println("Los Angeles Time:    " + losAngelesTime.format(formatter));
        System.out.println("Rio de Janeiro Time: " + rioTime.format(formatter));
        System.out.println("London Time:         " + londonTime.format(formatter));
        System.out.println("Mumbai Time:         " + mumbaiTime.format(formatter));
        System.out.println("Tokio Time:          " + tokioTime.format(formatter));
        System.out.println("Sydney Time:         " + sydneyTime.format(formatter));

        System.out.println();
    }
}
