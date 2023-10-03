package com.example.mod2.aop.task1;

import com.example.mod2.aop.task1.Book1;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect1 {


    @Pointcut("execution(* com.example.mod2.aop.task1.UniLibrary1.get*())")
    private void allGetMethodsFromUniLibrary1(){}

    @Pointcut ("execution(* com.example.mod2.aop.task1.UniLibrary1.return*())")
    private void allReturnMethodsFromUniLibrary1(){}

    @Pointcut ("allGetMethodsFromUniLibrary1() || allReturnMethodsFromUniLibrary1()")
    private void allGetAndReturnMethodsFromUniLibrary1(){}


    @Before("allGetMethodsFromUniLibrary1()")
    public void beforeGetLoggingAdvice1() {
        System.out.println("beforeGetLoggingAdvice: writting Log#1");
    }

    @Before("allReturnMethodsFromUniLibrary1()")
    public void beforeReturnLoggingAdvice1() {
        System.out.println("beforeReturnLoggingAdvice: writting Log#2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary1()")
    public void beforeGetAndReturnLoggingAdvice1() {
        System.out.println("beforeGetAndReturnLoggingAdvice: writting Log#3");
    }





    @Before("com.example.mod2.aop.Aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice1(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = "
                + methodSignature);

        System.out.println("methodSignature.getMethod = "
                + methodSignature.getMethod());

        System.out.println("methodSignature.getReturnType = "
                + methodSignature.getReturnType());

        System.out.println("methodSignature.getName = "
                + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for(Object obj:arguments) {
                if(obj instanceof Book1) {
                    Book1 myBook = (Book1) obj;
                    System.out.println("Информация о книге: название - "+
                            myBook.getName() + ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: логгирование попытки получить книгу/журнал");
        System.out.println("----------------------------------------------");

    }

}
