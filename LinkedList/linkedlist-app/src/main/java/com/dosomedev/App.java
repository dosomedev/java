package com.dosomedev;

import java.util.LinkedList;

/**
 * LinkedList example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Define and output.
         */
        LinkedList<String> names = new LinkedList<>();
        names.add("David");
        names.add("Jennifer");
        names.add("Elizabeth");

        System.out.println("LinkedList values: " + names);

        /*
         * Add and output.
         */
        names.add(0, "John");
        System.out.println("Added John at index 0: " + names);

        names.add(2, "Lawrence");
        System.out.println("Added Lawrence at index 2: " + names);

        names.add(1, "Rebecca");
        System.out.println("Added Rebecca at index 1: " + names);

        /*
         * Remove and output.
         */
        names.removeFirst();
        System.out.println("Removed first element: " + names);

        names.removeLast();
        System.out.println("Removed last element: " + names);

        names.remove(2);
        System.out.println("Removed element with index 2: " + names);

        names.remove("David");
        System.out.println("Removed David: " + names);
        
        names.add(0, "Marc");
        names.add(2, "Marc");
        names.add("Marc");
        System.out.println("LinkedList with multiple Marcs: " + names);

        names.removeFirstOccurrence("Marc");
        System.out.println("Removed first Marc: " + names);

        names.removeFirstOccurrence("Marc");
        System.out.println("Removed first Marc: " + names);

        names.removeFirstOccurrence("Marc");
        System.out.println("Removed first Marc: " + names);

        names.removeFirstOccurrence("Marc");
        System.out.println("Removed first Marc: " + names);
    }
}
