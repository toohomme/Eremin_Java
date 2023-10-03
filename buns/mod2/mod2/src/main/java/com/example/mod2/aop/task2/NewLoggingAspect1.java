package com.example.mod2.aop.task2;

import com.example.mod2.aop.task2.Book2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class NewLoggingAspect1 {

    @Pointcut("execution(* com.example.mod2.aop.task2.UniLibrary2.get*())")
    private void allGetMethodsFromUniLibrary2(){}

    @Pointcut("execution(* com.example.mod2.aop.task2.UniLibrary2.return*())")
    private void allReturnMethodsFromUniLibrary2(){}

    @Pointcut ("allGetMethodsFromUniLibrary2() || allReturnMethodsFromUniLibrary2()")
    private void allGetAndReturnMethodsFromUniLibrary2(){}


    @Before("allGetMethodsFromUniLibrary2()")
    public void beforeGetLoggingAdvice2() {
        System.out.println("beforeGetLoggingAdvice: writting Log#1");
    }

    @Before("allReturnMethodsFromUniLibrary2()")
    public void beforeReturnLoggingAdvice2() {
        System.out.println("beforeReturnLoggingAdvice: writting Log#2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary2()")
    public void beforeGetAndReturnLoggingAdvice2() {
        System.out.println("beforeGetAndReturnLoggingAdvice: writting Log#3");
    }


    @Before("com.example.mod2.aop.Aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice2(JoinPoint joinPoint) {

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
                if(obj instanceof Book2) {
                    Book2 myBook = (Book2) obj;
                    System.out.println("Информация о книге: название - "+
                            myBook.getName() + ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: логгирование попытки получить книгу");
        System.out.println("----------------------------------------------");

    }

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку" +
                " пытаются вернуть книгу");

        Object targetMethodResult = null;
        try {
             targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
//            targetMethodResult = "Неизвестное название книги";
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку" +
                " успешно вернули книгу");

        return targetMethodResult;
    }
}
