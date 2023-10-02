package com.example.mod1.task2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.mod1.task2.Pet2;
import org.springframework.beans.factory.annotation.Value;

@Component("personBean")
public class Person2 {
    private Pet2 pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    @Autowired
    public Person2(Pet2 pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }


    public Person2() {
        System.out.println("Person bean is created");
    }


    public void setPet(Pet2 pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hello, Pet");
        pet.say();
    }
}
