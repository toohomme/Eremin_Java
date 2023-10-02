package com.example.mod1.task1;

import com.example.mod1.task1.Person1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

        Person1 person = context.getBean("myPerson", Person1.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());


        context.close();
    }
}
