package com.example.mod1.task4;

import com.example.mod1.task4.MyConfig2;
import com.example.mod1.task4.Person4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        Person4 person = context.getBean("personBean", Person4.class);
        person.callYourPet();

        context.close();
    }
}
