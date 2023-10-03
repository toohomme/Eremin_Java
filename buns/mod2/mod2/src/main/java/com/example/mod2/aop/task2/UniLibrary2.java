package com.example.mod2.aop.task2;

import com.example.mod2.aop.task2.Book2;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary2 {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary2");
        System.out.println("----------------------------------------------");
    }

    public String returnBook(){
//        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniLibrary2");
        return "Война и мир";

    }

    public void addBook(String person_name, Book2 book){
        System.out.println("Мы добавляем книгу в UniLibrary2");
        System.out.println("----------------------------------------------");
    }

}
