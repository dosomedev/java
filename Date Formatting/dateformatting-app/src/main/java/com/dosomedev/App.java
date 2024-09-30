package com.dosomedev;

import com.dosomedev.CalendarExample.CalendarExample;
import com.dosomedev.DateExample.DateExample;
import com.dosomedev.FutureWorkdayExample.FutureWorkdayExample;
import com.dosomedev.HolidayExample.HolidayExample;
import com.dosomedev.JavaTimeExample.JavaTimeExample;
import com.dosomedev.OtherCalendarExample.OtherCalendarExample;
import com.dosomedev.TimeZoneExample.TimeZoneExample;

/**
 * Date formatting example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DateExample dateExample = new DateExample();
        dateExample.run();

        CalendarExample calendarExample = new CalendarExample();
        calendarExample.run();

        JavaTimeExample javaTimeExample = new JavaTimeExample();
        javaTimeExample.run();

        TimeZoneExample timeZoneExample = new TimeZoneExample();
        timeZoneExample.run();

        HolidayExample holidayExample = new HolidayExample();
        holidayExample.run();

        FutureWorkdayExample futureWorkdayExample = new FutureWorkdayExample();
        futureWorkdayExample.run();

        OtherCalendarExample otherCalendarExample = new OtherCalendarExample();
        otherCalendarExample.run();
    }
}
