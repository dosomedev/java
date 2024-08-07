package com.dosomedev;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * IdentityHashMap example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Create a HashMap and an IdentityHashMap.
         */

        HashMap<String, String> hashMap = new HashMap<>();
        IdentityHashMap<String, String>  identityHashMap = new IdentityHashMap<>();

        /*
         * Create two String objects with the same content.
         */

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        /*
         * Add key-value pairs to both maps.
         */

        hashMap.put(str1, "World");
        identityHashMap.put(str1, "World");

        /*
         * Try to retrieve the value using str1 and str2.
         */
        
        System.out.println("HashMap (str1): " + hashMap.get(str1)); // Output: World
        System.out.println("HashMap (str2): " + hashMap.get(str2)); // Output: World
        System.out.println("IdentityHashMap (str1): " + identityHashMap.get(str1)); // Output: World
        System.out.println("IdentityHashMap (str2): " + identityHashMap.get(str2)); // Output: null (IdentityHashMap uses reference equality)
    }
}
