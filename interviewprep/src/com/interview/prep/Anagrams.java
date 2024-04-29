package com.interview.prep;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        String string1 = "Heart";
        String string2 = "Earth2";
        String collect = Arrays.stream(string1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        String collect2 = Arrays.stream(string2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        if(collect.equals(collect2))
            System.out.println("Two String " + string1 + " and "
                    + string2 + " are Anagrams");
        else
            System.out.println("Two String " + string1 + " and "
                    + string2 + " are not Anagrams");

    }
}
