package com.dosomedev.FutureWorkdayExample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FutureHoliday {
    private List<LocalDate> holidays;

    public FutureHoliday() {
        this.holidays = new ArrayList<>();
    }

    public void addHolidays(List<LocalDate> holidays) {
        this.holidays.addAll(holidays);
    }

    public LocalDate getFutureWorkday(LocalDate startDate, int daysToAdd) {
        int daysDistance = 0;

        for (int i=1; i<=daysToAdd; i++) {
            daysDistance++;
            LocalDate checkDate = startDate.plusDays(daysDistance);
            if (this.isWeekend(checkDate) || this.isHoliday(checkDate)) {
                i--;
            }
        }

        return startDate.plusDays(daysDistance);
    }

    public static long getDayDistance(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    private boolean isHoliday(LocalDate date) {
        if (holidays.contains(date)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }
}
