package com.dosomedev;

import java.util.Optional;

/**
 * Optional example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OptionalExamples optionalExamples = new OptionalExamples();



        /*
         * Enhanced code readability and intent.
         */
        System.out.println("Enhanced code readability and intent:");

        String firstName = "John";
        String lastName = "Smith";

        // Test 1.
        String firstNameString = firstName;
        String lastNameString = null;
        Optional<String> firstNameOptional = Optional.ofNullable(firstName);
        Optional<String> lastNameOptional = Optional.ofNullable(null);

        String fullName1NullCheck = optionalExamples.getFullName(firstNameString, lastNameString);
        String fullName1Optional = optionalExamples.getFullName(firstNameOptional, lastNameOptional);
        System.out.println("Full name 1 (null check): " + fullName1NullCheck);
        System.out.println("Full name 1 (Optional):   " + fullName1Optional);

        // Test 2.
        firstNameString = null;
        lastNameString = lastName;
        firstNameOptional = Optional.ofNullable(null);
        lastNameOptional = Optional.ofNullable(lastName);

        String fullName2NullCheck = optionalExamples.getFullName(firstNameString, lastNameString);
        String fullName2Optional = optionalExamples.getFullName(firstNameOptional, lastNameOptional);
        System.out.println("Full name 2 (null check): " + fullName2NullCheck);
        System.out.println("Full name 2 (Optional):   " + fullName2Optional);

        // Test 3.
        firstNameString = firstName;
        lastNameString = lastName;
        firstNameOptional = Optional.ofNullable(firstName);
        lastNameOptional = Optional.ofNullable(lastName);

        String fullName3NullCheck = optionalExamples.getFullName(firstNameString, lastNameString);
        String fullName3Optional = optionalExamples.getFullName(firstNameOptional, lastNameOptional);
        System.out.println("Full name 3 (null check): " + fullName3NullCheck);
        System.out.println("Full name 3 (Optional):   " + fullName3Optional);

        System.out.println();



        /*
         * Get values using map and flatMap.
         */
        System.out.println("Get values using map and flatMap:");

        String catNameWithMap = optionalExamples.getValuesWithMap();
        String catNameWithFlatMap = optionalExamples.getValuesWithFlatMap();
        System.out.println("Get cat name with map():     " + catNameWithMap);
        System.out.println("Get cat name with flatMap(): " + catNameWithFlatMap);
        
        optionalExamples.getValuesWithIfPresentOrElse("Nala");
        optionalExamples.getValuesWithIfPresentOrElse(null);

        System.out.println();



        /*
         * Taking values.
         */
        System.out.println("Taking values:");

        optionalExamples.takingValues();

        System.out.println();



        /*
         * Method chaining.
         */
        System.out.println("Method chaining:");

        String name1 = optionalExamples.getNameConditional("John");
        String name2 = optionalExamples.getNameConditional("David");
        String name3 = optionalExamples.getNameConditional("Michael");
        String name4 = optionalExamples.getNameConditional("Christopher");

        System.out.println("Conditional name 1: " + name1);
        System.out.println("Conditional name 2: " + name2);
        System.out.println("Conditional name 3: " + name3);
        System.out.println("Conditional name 4: " + name4);

        System.out.println();



        /*
         * Provide default.
         */
        System.out.println("Provide default:");

        String mail1 = optionalExamples.provideDefaultValueWithOrElse("test@example.com");
        System.out.println("mail1: " + mail1);
        String mail2 = optionalExamples.provideDefaultValueWithOrElse(null);
        System.out.println("mail2: " + mail2);
        String mail3 = optionalExamples.provideDefaultValueWithOrElseGet("test@example.com");
        System.out.println("mail3: " + mail3);
        String mail4 = optionalExamples.provideDefaultValueWithOrElseGet(null);
        System.out.println("mail4: " + mail4);

        System.out.println();



        /*
         * Error handling.
         */
        System.out.println("Error handling:");

        try {
            String throw1 = optionalExamples.throwDefaultException("test@example.com");
            System.out.println("throw1: " + throw1);
        } catch (MyCustomException ex) {
            System.err.println("throw1 error: " + ex.getMessage());
        }

        try {
            String throw2 = optionalExamples.throwDefaultException(null);
            System.out.println("throw2: " + throw2);
        } catch (MyCustomException ex) {
            System.err.println("throw2 error: " + ex.getMessage());
        }

        System.out.println();
    }
}
