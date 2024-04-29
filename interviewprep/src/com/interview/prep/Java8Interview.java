package com.interview.prep;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import static java.util.List.of;

public class Java8Interview {

    public static void main(String[] args) {


        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int reduceSum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println(reduceSum);

        int reduceMultiply = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        System.out.println(reduceMultiply);

        // A simple map and reduce example to sum BigDecimal from a list of invoices.
        List<Invoice> invoices = Arrays.asList(
                new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        BigDecimal bigDecimal = invoices.stream().map(x -> x.getQty().multiply(x.price)).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        System.out.println(bigDecimal);

        // |a|b|c|d|e , the initial | join is not what we want
        String[] strings = {"a", "b", "c", "d", "e"};
        String join = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
        System.out.println(join);

        int a[] = {1, 4, 5, 2, 12, 34, 2, 12};

        Set<Integer> integerSet = new HashSet<>();

        Set<Integer> collect = Arrays.stream(a).boxed().filter(x -> !integerSet.add(x)).collect(Collectors.toSet());
        System.out.println(collect);

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        LinkedHashMap<String, Long> collect1 = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey()
                        .reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        System.out.println(collect1);

        int[] elements = {2, 333, 1, 4, 4, 1, 4, 333, 3, 333, 333, 2, 2, 5, 222};
        Integer key = Arrays.stream(elements).boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(Integer.MAX_VALUE);
        System.out.println(key);


        String inpuString = "i love my country ";
        String collect3 = Arrays.stream(inpuString.split(" ")).map(x -> new StringBuilder(x).reverse()).collect(Collectors.joining(" "));
        IntStream chars = inpuString.replaceAll("\\s", "").chars();
        Map<Character, Long> collect2 = chars.mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);
        System.out.println(collect3);
        /**
         * Find the frequency of each element in an array or a list
         *
         * Write a Java 8 program to find the frequency of
         * each element in an array or a list using streams and collectors.
         */

        wordFrequency();

        /**
         * Find the first repeated character in a string
         * Write a Java 8 program to find the first repeated character in a string.
         */
        firstRepeatedCharacter();


        /**
         * Find the frequency of each character in a string using Java 8 streams
         *
         * Write a Java 8 program to find the frequency of each character in
         * a given string using the stream API and collectors.
         */
        characterFrequency();

        /**
         * Sort a given list of decimals in reverse order
         *
         * Write a Java 8 program to sort a given list of decimal numbers in reverse order.
         */

        reverseSortedList();

        /**
         * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
         *
         * Given a list of strings, write a Java 8 program to join the strings
         * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
         */

        joinListOfStrings();

        /**
         * Merge two unsorted arrays into a single sorted array using Java 8 streams
         * Write a Java 8 program to merge two unsorted arrays into a single-sorted array using the stream API.
         */
        mergeUnsortedArrayIntoSorted();

        /**
         * Find the first non-repeated character in a string
         *
         * Write a Java 8 program to find the first non-repeated character in a string.
         */
        firstNonRepeatingCharacter();

        /**
         * Get the last element of an array
         *
         * Write a Java 8 program to get the last element of an array.
         */

        lastElementInTheArray();

        /**
         * Print the first 10 odd numbers
         *
         * Write a Java 8 program to print the first 10 odd numbers.
         */
        firstTenOddNumbers();

        /**
         * Check if a string is a palindrome using Java 8 streams
         *
         * Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.
         */

        checkIsTheStringPalindrome();


        /**
         * Find strings in a list that start with a number
         *
         * Given a list of strings, write a Java 8 program to find the strings that start with a number.
         */

        stringsStartsWithNumber();


    }

    private static void stringsStartsWithNumber() {

        String[] words = {"rohit", "foo", "nemo", "target1", "12Target", "2robot"};
        List<String> list = Arrays.stream(words)
                .filter(x -> Character.isDigit(x.charAt(0))).
                toList();
        List<String> list1 = Arrays.stream(words).filter(x -> x.startsWith("1")).toList();

        System.out.println(list1);

    }

    private static void checkIsTheStringPalindrome() {
        String palin = "madame";
        boolean match = IntStream.range(0, palin.length() / 2)
                .noneMatch(i -> palin.charAt(i) != palin.charAt(palin.length() - i - 1));
        System.out.println(match);
    }


    private static void firstTenOddNumbers() {

        IntStream.range(1, 10)
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
    }

    private static void lastElementInTheArray() {
        int[] intArray = {0, 1, 2, 3, 4, 5};
        Integer integer = Arrays.stream(intArray).boxed().skip(intArray.length - 1).findFirst().orElse(Integer.MIN_VALUE);
        System.out.println(integer);
    }

    private static void firstNonRepeatingCharacter() {
        String tempStr = "arohcitrohi";
        String stringLongEntry = Arrays.stream(tempStr.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
        System.out.println(stringLongEntry);

    }

    private static void firstRepeatedCharacter() {

        String word = "rohhttoh";
        Set<String> set = new HashSet<>();
        String s = Arrays.stream(word.split("")).filter(x -> !set.add(x)).findFirst().get();
        String stringLongEntry = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().
                filter(x -> x.getValue() > 1).findFirst().get().getKey();
        System.out.println(s);

    }

    private static void mergeUnsortedArrayIntoSorted() {

        int[] randomNumbers = {12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int[] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};
        int[] randomemerge = IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2)).sorted().toArray();
        int[] randomdupmerge = IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(randomemerge));
        System.out.println(Arrays.toString(randomdupmerge));
    }

    private static void joinListOfStrings() {
        List<String> languageList = of("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        String collect = languageList.stream().collect(Collectors.joining("|", "[", "]"));
        System.out.println(collect);
    }

    private static void reverseSortedList() {

        List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> collect = randomNumbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(collect);
    }

    private static void characterFrequency() {
        String name = "javaprep";
        Map<Character, Long> collect1 = name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> collect = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1 + "characterFrequency");
    }

    private static void wordFrequency() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }


}
