package com.example.mod1.task4;

import com.example.mod1.task4.Dog4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig2 {

    @Bean
    @Scope("singleton")
    public Pet4 dogBean() {
        return new Dog4();
    }

    @Bean
    public Person4 personBean() {
        return new Person4(dogBean());
    }
}
