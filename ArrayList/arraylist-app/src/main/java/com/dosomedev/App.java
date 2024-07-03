package com.dosomedev;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        Define and output.
        */

        String[] trees = new String[4];
        trees[0] = "Oak";
        trees[1] = "Palm";
        trees[2] = "Maple";
        trees[3] = "Pine";

        System.out.println("Array values:");
        for (int i=0; i<trees.length; i++) {
            System.out.println(trees[i]);
        }
        System.out.println();

        ArrayList<String> pets = new ArrayList<>();
        pets.add("Luna");
        pets.add("Charlie");
        pets.add("Bunny");
        pets.add("Sunshine");
        
        System.out.println("ArrayList values:");
        for (int i=0; i<pets.size(); i++) {
            System.out.println(pets.get(i));
        }
        System.out.println();

        /*
        Change and output.
        */

        trees[1] = "Cherry";

        System.out.println("Array values:");
        for (int i=0; i<trees.length; i++) {
            System.out.println(trees[i]);
        }
        System.out.println();

        pets.set(1, "Max");
        
        System.out.println("ArrayList values:");
        for (int i=0; i<pets.size(); i++) {
            System.out.println(pets.get(i));
        }
        System.out.println();

        /*
        Remove and output.
        */

        // Not possible with arrays.

        pets.remove(1);
        
        System.out.println("ArrayList values:");
        for (int i=0; i<pets.size(); i++) {
            System.out.println(pets.get(i));
        }
        System.out.println();

        /*
        Clear and output.
        */

        // Not possible with arrays.

        pets.clear();
        
        System.out.println("ArrayList values:");
        for (int i=0; i<pets.size(); i++) {
            System.out.println(pets.get(i));
        }
        System.out.println();
    }
}
