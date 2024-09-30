package com.dosomedev.HolidayExample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HolidayCounter {
    private final List<LocalDate> holidays;

    public HolidayCounter(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    public int countHolidays(int year) {
        int count = 0;
        for (LocalDate holiday : holidays) {
            if (holiday.getYear() == year) {
                count++;
            }
        }
        return count;
    }

    public int countWorkdays(int year) {
        int workdays = 0;
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

        while (startDate.isBefore(endDate.plusDays(1))) {
            if (!this.isWeekend(startDate)) {
                if (!this.isHoliday(startDate)) {
                    workdays++;
                }
            }
            
            startDate = startDate.plusDays(1);
        }

        return workdays;
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
