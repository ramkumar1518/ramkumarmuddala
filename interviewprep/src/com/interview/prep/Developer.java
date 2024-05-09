package com.interview.prep;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Developer {
    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) && Objects.equals(name, developer.name) && Objects.equals(book, developer.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, book);
    }

    private Set<String> book;

    //getters, setters, toString

    public Set<String> getBook() {
        return book;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
