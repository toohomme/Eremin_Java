package com.example.mod3.one_to_one;

import com.example.mod3.one_to_one.entity.Detail;
import com.example.mod3.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;


        try {

            //Добавление в БД
            session = factory.getCurrentSession();
            Employee employee = new Employee("Nikola", "Ivanov", "HR", 500);
            Detail detail = new Detail("Rom", "34848348", "Nikola@gmail.com");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();

            System.out.println("Done");


            //Вывод в консоль
//
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done");

//            session.beginTransaction();
//
//            //Удаление
//            Detail detail = session.get(Detail.class,1);
//            detail.getEmployee().setEmpDetail(null);
//            session.delete(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
        }

    finally {
            session.close();
            factory.close();
        }
    }
}
