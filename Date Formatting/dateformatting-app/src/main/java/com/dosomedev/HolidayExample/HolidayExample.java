package com.dosomedev.HolidayExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Holidays and work days (Zürich / Switzerland):");

        List<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(2024, 1, 1));   // Public holiday: Neujahr
        holidays.add(LocalDate.of(2024, 1, 2));   // Public holiday: Berchtoldstag
        holidays.add(LocalDate.of(2024, 3, 29));  // Public holiday: Karfreitag
        holidays.add(LocalDate.of(2024, 4, 1));   // Public holiday: Ostermontag
        holidays.add(LocalDate.of(2024, 5, 1));   // Public holiday: Tag der Arbeit
        holidays.add(LocalDate.of(2024, 5, 9));   // Public holiday: Christi Himmelfahrt
        holidays.add(LocalDate.of(2024, 5, 20));  // Public holiday: Pfingsmontag
        holidays.add(LocalDate.of(2024, 8, 1));   // Public holiday: Bundesfeiertag
        holidays.add(LocalDate.of(2024, 9, 15));  // Public holiday: Eidgenössischer Dank-, Buss- und Bettag
        holidays.add(LocalDate.of(2024, 12, 25)); // Public holiday: Erster Weihnachtstag
        holidays.add(LocalDate.of(2024, 12, 26)); // Public holiday: Stefanitag

        HolidayCounter counter = new HolidayCounter(holidays);

        int currentYear = LocalDate.now().getYear();
        int numPublicHolidays = counter.countHolidays(currentYear);
        int numWorkdays = counter.countWorkdays(currentYear);

        System.out.println("Public holidays " + currentYear + ": " + numPublicHolidays);
        System.out.println("Work days " + currentYear + ":       " + numWorkdays);

        System.out.println();
    }
}
