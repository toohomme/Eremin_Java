package com.example.mod1.task3;

import com.example.mod1.task3.Pet3;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("dogB")
public class Dog3 implements Pet3 {
    public Dog3(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
//    @PostConstruct
//    private void init() {
//        System.out.println("Class Dog3: init method");
//    }
//    @PreDestroy
//    private void destroy() {
//        System.out.println("Class Dog3: destroy method");
//    }
}
