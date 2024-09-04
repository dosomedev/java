package com.dosomedev;

import java.util.EnumMap;
import java.util.HashMap;

/**
 * EnumMap example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Define EnumMap.
        EnumMap<DayOfWeek, Double> temperatures = new EnumMap<>(DayOfWeek.class);

        // Add values.
        temperatures.put(DayOfWeek.MONDAY, 25.0);
        temperatures.put(DayOfWeek.TUESDAY, 28.0);
        temperatures.put(DayOfWeek.WEDNESDAY, 31.2);

        // Get value.
        Double mondayTemp = temperatures.get(DayOfWeek.MONDAY);
        System.out.println("Temperature on Monday: " + mondayTemp);

        // Check value.
        boolean tuesdayHasTemperature = temperatures.containsKey(DayOfWeek.TUESDAY);
        System.out.println("Does Tuesday have a temperature? " + (tuesdayHasTemperature ? "yes" : "no"));

        // Remove key-value pair.
        System.out.println();
        int sizeBeforeRemoval = temperatures.size();
        temperatures.remove(DayOfWeek.WEDNESDAY);
        int sizeAfterRemoval = temperatures.size();
        System.out.println("EnumMap size before removal: " + sizeBeforeRemoval);
        System.out.println("EnumMap size after removal:  " + sizeAfterRemoval);

        // Loop over all entries.
        System.out.println();
        System.out.println("List of all entries:");
        for (DayOfWeek day : temperatures.keySet()) {
            double temp = temperatures.get(day);
            System.out.println("- Temperature on " + day + ": " + temp);
        }

        // Clear the EnumMap.
        System.out.println();
        int sizeBeforeClear = temperatures.size();
        temperatures.clear();
        int sizeAfterClear = temperatures.size();
        System.out.println("EnumMap size before clear: " + sizeBeforeClear);
        System.out.println("EnumMap size after clear:  " + sizeAfterClear);

        // Performance test between EnumMap and HashMap.
        System.out.println();
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        HashMap<DayOfWeek, Integer> hashMap = new HashMap<>();
        int numTests = 100000000;
        System.out.printf("Performance test (quantity %,d) between EnumMap and HashMap:%n", numTests);

        // Fill maps with data.
        for (DayOfWeek day : DayOfWeek.values()) {
            enumMap.put(day, day.ordinal());
            hashMap.put(day, day.ordinal());
        }

        // Measure EnumMap speed.
        long enumMapStart = System.nanoTime();
        for (int i=0; i<numTests; i++) {
            for (DayOfWeek day : DayOfWeek.values()) {
                enumMap.get(day);
            }
        }
        long enumMapEnd = System.nanoTime();

        // Measure HashMap speed.
        long hashMapStart = System.nanoTime();
        for (int i=0; i<numTests; i++) {
            for (DayOfWeek day : DayOfWeek.values()) {
                hashMap.get(day);
            }
        }
        long hashMapEnd = System.nanoTime();

        // Calculate results.
        long enumMapTime = enumMapEnd - enumMapStart;
        long hashMapTime = hashMapEnd - hashMapStart;
        System.out.println("EnumMap time: " + enumMapTime / numTests + " ms");
        System.out.println("HashMap time: " + hashMapTime / numTests + " ms");
    }
}
