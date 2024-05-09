package com.interview.prep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.setId(100);
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o1.setId(100);
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        List<String> java = list.stream().map(Developer::getBook).flatMap(Collection::stream)
                .filter(x -> x.toLowerCase().contains("python"))
                .collect(Collectors.toList());
        System.out.println(java);
    }
}
