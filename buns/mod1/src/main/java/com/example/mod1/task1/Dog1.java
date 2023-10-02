package com.example.mod1.task1;

import com.example.mod1.task1.Pet1;

public class Dog1 implements Pet1 {
    private String name;

    public Dog1(){
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
