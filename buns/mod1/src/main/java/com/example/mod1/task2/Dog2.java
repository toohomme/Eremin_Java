package com.example.mod1.task2;

import com.example.mod1.task2.Pet2;
import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog2 implements Pet2 {
    private String name;

    public Dog2(){
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }


}
