package com.example.mod1.task4;

import com.example.mod1.task4.Pet4;
import org.springframework.stereotype.Component;

public class Dog4 implements Pet4 {
    public Dog4(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
