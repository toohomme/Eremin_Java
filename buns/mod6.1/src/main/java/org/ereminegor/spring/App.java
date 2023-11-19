package org.ereminegor.spring;

import org.ereminegor.spring.config.Config;
import org.ereminegor.spring.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
        System.out.println(communication.getAllEmployees());
        Employee employee = communication.getEmployeeById(1);
        System.out.println(employee);

    }
}
