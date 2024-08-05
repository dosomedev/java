package com.dosomedev;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Define map.
         */

        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        /*
         * Add words.
         */

        words.put("we", 1);
        words.put("of", 2);
        words.put("that", 3);
        words.put("these", 2);
        words.put("the", 2);

        /*
         * Get existing word.
         */

        Integer wordOf = words.get("of");
        System.out.println("Word count for 'of': " + wordOf);

        /*
         * Get non-existing word.
         */

        Integer wordAre = words.get("are");
        System.out.println("Word count for 'are': " + wordAre);

        /*
         * Test word presence.
         */

        if (words.containsKey("of")) {
            System.out.println("Word 'of' exists.");
        } else {
            System.out.println("Word 'of' does not exist.");
        }

        if (words.containsKey("are")) {
            System.out.println("Word 'are' exists.");
        } else {
            System.out.println("Word 'are' does not exist.");
        }

        /*
         * Remove word.
         */

        System.out.println("Number of words (before removal): " + words.size());
        words.remove("of");
        System.out.println("Number of words (after removal): " + words.size());

        /*
         * List words.
         */

        System.out.println("List of words (key : value):");
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            System.out.println("- " + word.getKey() + " : " + word.getValue());
        }

        /*
         * Compare LinkedHashMap to HashMap order.
         */

        HashMap<String, Integer> map1 = new HashMap<>();
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();

        map1.put("we", 1);
        map1.put("of", 2);
        map1.put("that", 3);
        map1.put("these", 2);
        map1.put("the", 2);

        map2.put("we", 1);
        map2.put("of", 2);
        map2.put("that", 3);
        map2.put("these", 2);
        map2.put("the", 2);

        System.out.println("List of words (HashMap):");
        for (Map.Entry<String, Integer> word : map1.entrySet()) {
            System.out.println("- " + word.getKey() + " : " + word.getValue());
        }

        System.out.println("List of words (LinkedHashMap):");
        for (Map.Entry<String, Integer> word : map2.entrySet()) {
            System.out.println("- " + word.getKey() + " : " + word.getValue());
        }
    }
}
