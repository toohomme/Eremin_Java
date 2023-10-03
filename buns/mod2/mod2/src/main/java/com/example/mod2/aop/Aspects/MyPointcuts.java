package com.example.mod2.aop.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution( * add*(..))")
    public void allAddMethods(){}

}
