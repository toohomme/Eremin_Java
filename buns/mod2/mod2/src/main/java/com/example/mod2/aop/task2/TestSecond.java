package com.example.mod2.aop.task2;

import com.example.mod2.aop.task1.UniLibrary1;
import com.example.mod2.aop.task2.Book2;
import com.example.mod2.aop.task2.MyConfig2;
import com.example.mod2.aop.task2.UniLibrary2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSecond {
    public static void main(String[] args) {
        System.out.println("method main starts");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        UniLibrary2 uniLibrary2 = context.getBean("uniLibrary2", UniLibrary2.class);
        UniLibrary2 library2 = context.getBean("uniLibrary2", UniLibrary2.class);
        Book2 book2 = context.getBean("book2", Book2.class);

        uniLibrary2.getBook();
        uniLibrary2.addBook("Egor",book2);

        String bookName = library2.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println("method main ends");
    }
}
