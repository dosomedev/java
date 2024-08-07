package com.dosomedev;

import java.util.TreeSet;

/**
 * TreeSet example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Create a TreeSet to store unique names.
         */

        TreeSet<String> names = new TreeSet<>();

        /*
         * Add new names.
         */

        names.add("Olivia");
        names.add("Noah");
        names.add("Charlotte");

        /*
         * Add existing names.
         */

        names.add("Olivia");

        /*
         * Check if a name exists.
         */

        if (names.contains("Riley")) {
            System.out.println("Riley is in the set.");
        } else {
            System.out.println("Riley is not in the set.");
        }

        /*
         * Print number of unique names.
         */

        System.out.println("Total names: " + names.size());

        /*
         * Remove name.
         */

        names.remove("Noah");
        System.out.println("Removed Noah.");

        /*
         * Iterate through the names.
         */

        System.out.println("List of names:");
        for (String name : names) {
            System.out.println("- " + name);
        }

        /*
         * Empty the set.
         */

        names.clear();
        System.out.println("Emptied the set.");
        
        System.out.println("List of names:");
        for (String name : names) {
            System.out.println("- " + name);
        }
    }
}
