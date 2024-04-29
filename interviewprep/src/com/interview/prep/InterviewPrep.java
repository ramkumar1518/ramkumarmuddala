package com.interview.prep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewPrep {

    public static void main(String[] args) {

        // Find Largest Palindrome String from List of Strings
        List<String> stringList = Arrays.asList("telugu", "tamil", "malayalam", "madam");

        Optional<String> collect = stringList.stream().filter(x -> x.contentEquals(
                new StringBuilder(x).reverse())).toList().stream().max(Comparator.comparingInt(String::length));
        System.out.println(collect);

        String  palString= "madam2";
        boolean palCheck = palString.contentEquals(new StringBuilder(palString).reverse());
        if(palCheck){
            System.out.println("Palinedrom String " + palString);
        }else{
            System.out.println("Not Palinedrom String " + palString);
        }


        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

        Map<String, Long> collect1 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        List<Double> sorted = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String collect2 = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect2);

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        List<Integer> collect3 = listOfIntegers.stream().filter(x -> x % 5 == 0).collect(Collectors.toList());
        System.out.println(collect3);


        Integer collect4 = Stream.of(String.valueOf(15623).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(collect4);

        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer i1;
        i1 = listOfIntegers1.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i1);

        List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        List<String> collect5 = listOfStrings2.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(collect5);


        List<Hosting> hostinglist = new ArrayList<>();
        hostinglist.add(new Hosting(1, "liquidweb.com", 80000));
        hostinglist.add(new Hosting(2, "linode.com", 90000));
        hostinglist.add(new Hosting(3, "digitalocean.com", 120000));
        hostinglist.add(new Hosting(4, "aws.amazon.com", 200000));
        hostinglist.add(new Hosting(5, "mkyong.com", 1));
        hostinglist.add(new Hosting(6, "linode.com", 100000));

        LinkedHashMap<String, Long> collect6 = hostinglist.stream().sorted(Comparator.comparing(Hosting::getWebsites).reversed()).collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                (o1, o2) -> o2, LinkedHashMap::new));
        System.out.println(collect6);


    }
}
