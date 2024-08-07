package com.dosomedev;

import java.util.WeakHashMap;

/**
 * WeakHashMap example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Define the map.
         */

        WeakHashMap<Object, String> map = new WeakHashMap<>();

        /*
         * Add objects.
         */

        Object key1 = new Object();
        Object key2 = new Object();

        map.put(key1, "Value for key1");
        map.put(key2, "Value for key2");

        System.out.println("Map size: " + map.size());

        /*
         * Remove object reference.
         */

        key1 = null;

        System.out.println("Map size before GC: " + map.size());

        System.gc();

        System.out.println("Map size after GC: " + map.size());

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Map size after GC: " + map.size());

        System.out.println(map.get(key2));
    }
}
