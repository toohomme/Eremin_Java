package com.example.mod2.aop.task2;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.mod2.aop")
@EnableAspectJAutoProxy
public class MyConfig2 {

}
