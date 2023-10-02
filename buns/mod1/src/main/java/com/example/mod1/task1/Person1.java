package com.example.mod1.task1;

import com.example.mod1.task1.Pet1;
import org.springframework.beans.factory.annotation.Value;

public class Person1 {

    private Pet1 pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person1(Pet1 pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public Person1() {
        System.out.println("Person bean is created");
    }

    public void setPet(Pet1 pet) {
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
