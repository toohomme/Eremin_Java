package com.example.mod2.aop.task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book2 {
    @Value("Мастер и Маргарита")
    private String name;

    @Value("Булгаков")
    private String author;

    @Value("1966")
    private int yearOfPublication;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getName() {
        return name;
    }
}
