package com.example.mod1.task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig1.class);

        Person3 person = context.getBean("personB", Person3.class);
        person.callYourPet();

        context.close();
    }
}
