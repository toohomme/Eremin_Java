package com.example.mod2.aop.task1;

import com.example.mod2.aop.task1.Book1;
import com.example.mod2.aop.task1.MyConfig1;
import com.example.mod2.aop.task1.UniLibrary1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestFirst {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig1.class);

        UniLibrary1 uniLibrary1 = context.getBean("uniLibrary1", UniLibrary1.class);
        Book1 book1 = context.getBean("book1", Book1.class);

        uniLibrary1.getBook();
        uniLibrary1.addBook("Egor",book1);
        context.close();
    }
}
