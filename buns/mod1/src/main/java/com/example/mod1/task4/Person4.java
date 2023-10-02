package com.example.mod1.task4;

import com.example.mod1.task4.Pet4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Person4 {
    private Pet4 pet;
    private String surname;
    private int age;


    public Person4( Pet4 pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void setPet(Pet4 pet) {
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
