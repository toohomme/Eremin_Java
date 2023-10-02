package com.example.mod1.task3;

import com.example.mod1.task3.Pet3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personB")
public class Person3 {
    private Pet3 pet;
    private String surname;
    private int age;

    @Autowired
    public Person3(@Qualifier("dogB") Pet3 pet) {
 System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void setPet(Pet3 pet) {
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
