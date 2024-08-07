package com.dosomedev;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Define map.
         */

        TreeMap<String, Integer> words = new TreeMap<>();

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
         * Creating a custom comparator.
         */

        Comparator<String> comparatorByCount = new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        };
        TreeMap<String, Integer> wordsWithComparator = new TreeMap<>(comparatorByCount);

        wordsWithComparator.put("we", 1);
        wordsWithComparator.put("of", 2);
        wordsWithComparator.put("that", 3);
        wordsWithComparator.put("these", 2);
        wordsWithComparator.put("the", 2);

        System.out.println("List of words (key : value) with custom comparator:");
        for (Map.Entry<String, Integer> word : wordsWithComparator.entrySet()) {
            System.out.println("- " + word.getKey() + " : " + word.getValue());
        }
    }
}
