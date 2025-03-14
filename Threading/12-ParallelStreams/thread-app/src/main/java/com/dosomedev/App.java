package com.dosomedev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Stream from array.
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream arrayStream = Arrays.stream(numbers);
        List<Integer> array = arrayStream
            .boxed()
            .collect(Collectors.toList());
        System.out.printf("ArrayStream: %s%n", array);

        // Stream of values.
        Stream<String> valuesStream = Stream.of("Maggie", "Amelia", "Charlotte");
        List<String> valueArray = valuesStream
            .collect(Collectors.toList());
        System.out.printf("ValueStream: %s%n", valueArray);

        // Specialized streams for primitive types to avoid boxing/unboxing overhead.
        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.range(1, 5);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
        List<Integer> intArray = intStream
            .boxed()
            .collect(Collectors.toList());
        List<Long> longArray = longStream
            .boxed()
            .collect(Collectors.toList());
        List<Double> doubleArray = doubleStream
            .boxed()
            .collect(Collectors.toList());
        System.out.printf("IntStream:    %s%n", intArray);
        System.out.printf("LongStream:   %s%n", longArray);
        System.out.printf("DoubleStream: %s%n", doubleArray);

        // Flatten a list.
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        List<Integer> flattenedList = nestedList.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.printf("Nested list:    %s%n", nestedList);
        System.out.printf("Flattened list: %s%n", flattenedList);

        // Examples for sequential and parallel streams.
        for (StreamType streamType : StreamType.values()) {
            StreamExamples example = new StreamExamples(streamType);
            // example.filterElements();
            // example.transformElements();
            // example.sortElements();
            // example.customSortElements();
            // example.concatenateTwoStreams();
            // example.removeDuplicates();
            // example.terminalOperationForEach();
            // example.countElements();
            // example.collectElements();
            // example.groupElements();
            // example.partitionElements();
            // example.collectJoinElements();
            // example.peekAtEachElement();
            // example.checkForAnyMatch();
            // example.checkForAllMatch();
            // example.checkForNoneMatch();
            // example.checkForFindFirst();
            // example.checkForFindAny();
            // example.reduceElementsConcatenation();
            // example.reduceElementsToLongestName();
            // example.reduceElementsToFirstNameAlphabetically();
            example.createStatistics();
        }
    }
}
