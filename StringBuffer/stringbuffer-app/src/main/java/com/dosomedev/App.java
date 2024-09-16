package com.dosomedev;

/**
 * StringBuffer example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create a StringBuffer.
        StringBuffer sb = new StringBuffer();

        // Append strings.
        sb.append("Hello, ");
        sb.append("my friend!");
        System.out.println(sb);
        System.out.println();

        // Insert string at a specific index.
        System.out.println("Insert string at a specific index:");
        System.out.println(sb.insert(5, " there"));
        System.out.println(sb);
        System.out.println();

        // Replace a portion of the StringBuffer.
        System.out.println("Replace a portion of the StringBuffer:");
        sb.replace(0, 11, "Goodbye");
        System.out.println(sb);
        System.out.println();

        // Get a substring.
        System.out.println("Get a substring:");
        String substring = sb.substring(9, 18);
        System.out.println("Substring: " + substring);
        System.out.println();

        // Delete characters within a range.
        System.out.println("Delete characters within a range:");
        sb.delete(7, 18);
        System.out.println(sb);
        System.out.println();

        // Reverse the order of characters.
        System.out.println("Reverse the order of characters:");
        sb.reverse();
        System.out.println(sb);
        System.out.println();

        // Get the current length.
        System.out.println("Get the current length:");
        int length = sb.length();
        System.out.println("Length: " + length);
        System.out.println();

        // Get the capacity.
        System.out.println("Get the capacity:");
        int capacity = sb.capacity();
        System.out.println("Capacity: " + capacity);
        System.out.println();

        // Convert the StringBuffer to a String.
        System.out.println("Convert the StringBuffer to a String:");
        String str = sb.toString();
        System.out.println("String: " + str);
        System.out.println();

        // Check if the StringBuffer is empty.
        System.out.println("Check if the StringBuffer is empty:");
        boolean isEmpty = sb.isEmpty();
        System.out.println("Is empty now?: " + isEmpty);
        sb.delete(0, sb.length());
        isEmpty = sb.isEmpty();
        System.out.println("Is empty now?: " + isEmpty);
        System.out.println();
    }
}
