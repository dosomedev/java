package com.dosomedev;

import java.util.Vector;

/**
 * Vector example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Define and output.
         */
        Vector<String> names = new Vector<>();
        names.add("David");
        names.add("Jennifer");
        names.add("Elizabeth");
        System.out.println("Vector values: " + names);
        System.out.println("Name at index 1: " + names.get(1));
        System.out.println("Getting values using for-loop:");
        for (int i=0; i<names.size(); i++) {
            System.out.println("   Value " + i + ": " + names.get(i));
        }

        /*
         * Change and output.
         */
        names.set(1, "Rebecca");
        System.out.println("Changed name at index 1: " + names);

        names.set(2, "Tony");
        System.out.println("Changed name at index 2: " + names);
        
        /*
         * Remove and output.
         */
        names.remove(1);
        System.out.println("Removed name at index 1: " + names);
        
        names.remove(1);
        System.out.println("Removed name at index 1: " + names);

        names.clear();
        System.out.println("Cleared all names: " + names);
    }
}
