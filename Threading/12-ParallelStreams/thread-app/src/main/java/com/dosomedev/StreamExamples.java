package com.dosomedev;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    private BabyNames babyNames;

    public StreamExamples(StreamType streamType) {
        // Print welcome message.
        String message = String.format("Stream Examples with %s.", streamType.toString());
        System.out.println();
        System.out.println("#".repeat(message.length() + 4));
        System.out.println("# " + message + " #");
        System.out.println("#".repeat(message.length() + 4));
        System.out.println();

        // Load baby names.
        this.babyNames = new BabyNames(streamType);
        this.babyNames.loadBabyNames();
        warmUp();
    }

    public void filterElements() {
        long startTime = 0;
        long endTime = 0;

        // Filter elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        startTime = System.nanoTime();
        List<String> filteredList = maleStream
            .filter(s -> s.startsWith("A"))
            .collect(Collectors.toList());
        endTime = System.nanoTime();

        // Print message.
        String message = String.format("Names before filter: %s, names after filter: %s", babyNames.getMaleNames().count(), filteredList.size());
        printElapsedTime("Filter elements", startTime, endTime, message);
    }

    public void transformElements() {
        // Transform elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        List<Integer> transformedList = maleStream
            .map(String::length)
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        // Print message.
        int lengthSum = transformedList.stream()
            .mapToInt(Integer::intValue)
            .sum();
        String message = String.format("Quantity of name counts: %s, having a total character sum of: %s",
                                        transformedList.size(), lengthSum);
        printElapsedTime("Transform elements", startTime, endTime, message);
    }

    public void sortElements() {
        // Sort elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        List<String> sortedList = maleStream
            .sorted()
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Sort elements", startTime, endTime);
    }

    public void customSortElements() {
        // Sort elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        List<String> sortedList = maleStream
            .sorted()
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Custom sort elements", startTime, endTime);
    }

    public void concatenateTwoStreams() {
        // Concatenate two streams.
        Stream<String> maleStream = babyNames.getMaleNames();
        Stream<String> femaleStream = babyNames.getFemaleNames();
        long startTime = System.nanoTime();
        Stream<String> concatenateStream = Stream.concat(maleStream, femaleStream);
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("Male names: %s, female names: %s, total names: %s", babyNames.getMaleNames().count(), babyNames.getFemaleNames().count(), concatenateStream.count());
        printElapsedTime("Concatenate streams", startTime, endTime, message);
    }

    public void removeDuplicates() {
        // Remove duplicates.
        Stream<String> maleStream = babyNames.getMaleNames();
        Stream<String> femaleStream = babyNames.getFemaleNames();
        Stream<String> concatenatedStream = Stream.concat(maleStream, femaleStream);
        long startTime = System.nanoTime();
        List<String> distinctNames = concatenatedStream
            .distinct()
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("Total names: %s, distinct names: %s", babyNames.getMaleNames().count() + babyNames.getFemaleNames().count(), distinctNames.size());
        printElapsedTime("Remove duplicates", startTime, endTime, message);
    }

    public void terminalOperationForEach() {
        // Terminal operation forEach.
        ConcurrentLinkedQueue<String> maleQueue = new ConcurrentLinkedQueue<>();
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        maleStream
            .forEach(f -> {
                if (f.length() > 10) {
                    String upperCaseName = f.toUpperCase();
                    maleQueue.add(upperCaseName);
                }
            });
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Terminal operation forEach", startTime, endTime);
    }

    public void countElements() {
        // Count elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        long countResult = maleStream.count();
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("Counted a total of %s male names.", countResult);
        printElapsedTime("Count elements", startTime, endTime, message);
    }

    public void collectElements() {
        // Collect elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        List<String> collectedElements = maleStream
            .collect(Collectors.toList());
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Collect elements", startTime, endTime);
    }

    public void groupElements() {
        // Group elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Map<Integer, List<String>> groupedElements = maleStream
            .collect(Collectors.groupingBy(String::length));
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Group elements", startTime, endTime);
    }

    public void partitionElements() {
        // Partition elements.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Map<Boolean, List<String>> partitionedElements = maleStream
            .collect(Collectors.partitioningBy(s -> s.length() > 3));
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Partition elements", startTime, endTime);
    }

    public void collectJoinElements() {
        // Combine a stream into a single string.
        long startTime = System.nanoTime();
        Stream<String> maleStream = babyNames.getMaleNames();
        String concatenatedString = maleStream
            .filter(s -> s.startsWith("Y"))
            .distinct()
            .collect(Collectors.joining(", ", "[[[", "]]]"));
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Collect and join elements", startTime, endTime, concatenatedString);
    }

    public void peekAtEachElement() {
        // Peek at each element of the stream without changing its contents.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        List<String> processedElements = maleStream
            .filter(s -> s.startsWith("Alb"))
            .distinct()
            .peek(s -> System.out.println("peek1: " + s))
            .sorted()
            // .peek(s -> System.out.println("peek2: " + s)) // No order guaranteed in parallel.
            .collect(Collectors.toList());
        processedElements.forEach(s -> System.out.println("peek2: " + s));
        long endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Peeked at elements", startTime, endTime);
    }

    public void checkForAnyMatch() {
        // Check if any element matches a predicate.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        String searchKey = "A";
        boolean matchResult = maleStream
            .anyMatch(s -> s.startsWith(searchKey));
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("any match of '%s', result: %s", searchKey, matchResult);
        printElapsedTime("Check any match", startTime, endTime, message);
    }

    public void checkForAllMatch() {
        // Check all elements against a string length value.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        int compareValue = 2;
        boolean matchResult = maleStream
            .allMatch(s -> s.length() >= compareValue);
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("all name lengths at minimum %s, result: %s", compareValue, matchResult);
        printElapsedTime("Check all match", startTime, endTime, message);
    }

    public void checkForNoneMatch() {
        // Check if no element matches a predicate.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        int compareValue = 1;
        boolean matchResult = maleStream
            .noneMatch(s -> s.length() == compareValue);
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("no name length is %s, result: %s", compareValue, matchResult);
        printElapsedTime("Check none match", startTime, endTime, message);
    }

    public void checkForFindFirst() {
        // Find first name. Order not guaranteed in parallel streams.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Optional<String> findFirstResult = maleStream.findFirst();
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("find first, result: %s", findFirstResult.orElse(""));
        printElapsedTime("Find first", startTime, endTime, message);
    }

    public void checkForFindAny() {
        // Find any name. Order not guaranteed in parallel streams.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Optional<String> findAnyResult = maleStream.findAny();
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format("find any result: %s", findAnyResult.orElse(""));
        printElapsedTime("Find any", startTime, endTime, message);
    }

    public void reduceElementsConcatenation() {
        // Concatenate all strings into a single string with separator.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        String concatenatedString = maleStream
            .reduce("", (s1, s2) -> s1 + ", " + s2);
        long endTime = System.nanoTime();
        // Remove leading comma.
        if (concatenatedString.startsWith(", ")) {
            concatenatedString = concatenatedString.substring(2);
        }
        // System.out.println(concatenatedString);

        // Print message.
        printElapsedTime("Reduce to single string", startTime, endTime);
    }

    public void reduceElementsToLongestName() {
        // Find longest name.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Optional<String> longestName = maleStream
            .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        long endTime = System.nanoTime();

        // Print message.
        String message = "longest name result: ";
        if (longestName.isPresent()) {
            message += longestName.get();
        } else {
            message += "none";
        }
        printElapsedTime("Reduce to longest name", startTime, endTime, message);
    }

    public void reduceElementsToFirstNameAlphabetically() {
        // Find first name alphabetically.
        Stream<String> maleStream = babyNames.getMaleNames();
        long startTime = System.nanoTime();
        Optional<String> firstNameAlphabetically = maleStream
            .reduce((s1, s2) -> s1.compareTo(s2) <= 0 ? s1 : s2);
        long endTime = System.nanoTime();

        // Print message.
        String message = "first alphabetically result: ";
        if (firstNameAlphabetically.isPresent()) {
            message += firstNameAlphabetically.get();
        } else {
            message += "none";
        }
        printElapsedTime("Reduce to first name alphabetically", startTime, endTime, message);
    }

    public void createStatistics() {
        // Count, sum, minimum, average, and maximum values of the stream.
        Stream<String> maleStream = babyNames.getMaleNames();
        Stream<String> femaleStream = babyNames.getFemaleNames();
        long startTime = System.nanoTime();
        List<Integer> maleNameLengths = maleStream
            .map(String::length)
            .collect(Collectors.toList());
        List<Integer> femaleNameLengths = femaleStream
            .map(String::length)
            .collect(Collectors.toList());
        IntSummaryStatistics maleNameStatistics = maleNameLengths.stream()
            .collect(Collectors.summarizingInt(Integer::intValue));
        IntSummaryStatistics femaleNameStatistics = femaleNameLengths.stream()
            .collect(Collectors.summarizingInt(Integer::intValue));
        long endTime = System.nanoTime();

        // Print message.
        String message = String.format(
            "Male Names [count: %s, sum: %s, min: %s, average: %s, max: %s], Female Names: [count: %s, sum: %s, min: %s, average: %s, max: %s]",
            maleNameStatistics.getCount(),
            maleNameStatistics.getSum(),
            maleNameStatistics.getMin(),
            maleNameStatistics.getAverage(),
            maleNameStatistics.getMax(),
            femaleNameStatistics.getCount(),
            femaleNameStatistics.getSum(),
            femaleNameStatistics.getMin(),
            femaleNameStatistics.getAverage(),
            femaleNameStatistics.getMax()
        );
        printElapsedTime("Create statistics", startTime, endTime, message);
    }

    private void warmUp() {
        long startTime = 0;
        long endTime = 0;

        // Warm-up JIT for benchmark.
        startTime = System.nanoTime();
        List<String> warmUpDummyList = babyNames.getMaleNames().collect(Collectors.toList());
        endTime = System.nanoTime();

        // Print message.
        printElapsedTime("Warm-up", startTime, endTime);
    }

    private void printElapsedTime(String name, long nanoStart, long nanoEnd) {
        printElapsedTime(name, nanoStart, nanoEnd, null);
    }

    private void printElapsedTime(String name, long nanoStart, long nanoEnd, String message) {
        long nanoElapsed = nanoEnd - nanoStart;
        double milliElapsed = nanoElapsed / 1000000.0;
        if (message == null || message.isEmpty()) {
            System.out.printf("%-37s %7.3fms%n", name + ":", milliElapsed);
        } else {
            System.out.printf("%-37s %7.3fms, %s%n", name + ":", milliElapsed, message);
        }
    }
}
