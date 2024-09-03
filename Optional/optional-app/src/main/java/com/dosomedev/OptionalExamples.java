package com.dosomedev;

import java.util.Optional;

public class OptionalExamples {
    /*
     * Get full name using null check.
     */
    public String getFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return "Cannot provide full name.";
        } else {
            return firstName + " " + lastName;
        }
    }
    
    /*
     * Get full name using Optional.
     */
    public String getFullName(Optional<String> firstName, Optional<String> lastName) {
        return firstName
            .flatMap(first -> lastName.map(last -> first + " " + last))
            .orElse("Cannot provide full name.");
    }

    /*
     * Get values using map and map().
     */
    public String getValuesWithMap() {
        Animal animal = new Animal();
        animal.setName("Nala");
        Optional<Animal> animalOptional = Optional.ofNullable(animal);
        
        Optional<String> nameOptionalWithMap = animalOptional.map(Animal::getName);
        if (nameOptionalWithMap.isPresent()) {
            return "Animal name (map): " + nameOptionalWithMap.get();
        } else {
            return "Animal name (map) is null";
        }
    }

    /*
     * Get values using flatMap().
     */
    public String getValuesWithFlatMap() {
        Animal animal = new Animal();
        animal.setName("Nala");
        Optional<Animal> animalOptional = Optional.ofNullable(animal);

        // This will work.
        Optional<String> nameOptionalWithFlatMap = animalOptional.flatMap(flatAnimal -> Optional.ofNullable(flatAnimal.getName()));
        if (nameOptionalWithFlatMap.isPresent()) {
            return "Animal name (flatMap): " + nameOptionalWithFlatMap.get();
        } else {
            return "Animal name (flatMap) is null";
        }
    }

    /*
     * Taking values.
     */
    public void takingValues() {
        Optional<String> a1 = Optional.of("Maxi");         // Taking a non-null value.
        //Optional<String> a2 = Optional.of(null);               // Error: Cannot take null values.
        Optional<String> a3 = Optional.ofNullable("Maxi"); // Taking a value that might be null.
        Optional<String> a4 = Optional.ofNullable(null);   // Taking a value that is null.
        Optional<String> a5 = Optional.empty();                  // Creating an empty Optional.
        
        System.out.println("a1: " + a1);
        //System.out.println("a2: " + a2);
        System.out.println("a3: " + a3);
        System.out.println("a4: " + a4);
        System.out.println("a5: " + a5);
    }

    /*
     * Get values with ifPresentOrElse.
     */
    public void getValuesWithIfPresentOrElse(String name) {
        Optional<String> maybeName = Optional.ofNullable(name);

        maybeName.ifPresentOrElse(
            theName -> System.out.println("name: " + theName),
            () -> System.out.println("name is null")
        );
    }

    /*
     * Conditional chain.
     */
    public String getNameConditional(String name) {
        Optional<String> maybeName = Optional.ofNullable(name);

        String result = maybeName
            .map(String::toUpperCase)
            .filter(nameString -> nameString.length() > 5)
            .orElse("Default Name");

        return result;
    }

    /*
     * Provide default value with orElse.
     */
    public String provideDefaultValueWithOrElse(String email) {
        Optional<String> maybeDefault = Optional.ofNullable(email);

        return maybeDefault.orElse("default@example.com");
    }

    /*
     * Provide default value with orElseGet.
     */
    public String provideDefaultValueWithOrElseGet(String email) {
        Optional<String> maybeDefault = Optional.ofNullable(email);

        return maybeDefault.orElseGet(() -> {
            System.out.println("Given eMail was null. Generating default eMail.");
            return "default@example.com";
        });
    }

    /*
     * Throw default exception.
     */
    public String throwDefaultException(String email) throws MyCustomException {
        Optional<String> maybeDefault = Optional.ofNullable(email);

        return maybeDefault.orElseThrow(() -> new MyCustomException("My custom message!"));
    }
}
