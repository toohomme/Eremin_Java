package com.example.mod2.aop.task1;

import com.example.mod2.aop.task1.Book1;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary1 {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary1");
        System.out.println("----------------------------------------------");
    }

    public String returnBook(){
//        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniLibrary1");
        return "Война и мир";

    }

    public void addBook(String person_name, Book1 book){
        System.out.println("Мы добавляем книгу в UniLibrary1");
        System.out.println("----------------------------------------------");
    }

}
