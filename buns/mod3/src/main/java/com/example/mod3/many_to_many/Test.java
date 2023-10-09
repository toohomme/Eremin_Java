package com.example.mod3.many_to_many;

import com.example.mod3.many_to_many.entity.Child;
import com.example.mod3.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        //Добавление трех детей, привязанных к одной секции
        try{
            session = factory.getCurrentSession();
            Section section1 = new Section("Fooball");
            Child child1 = new Child("Egor",5);
            Child child2 = new Child("Misha",6);
            Child child3 = new Child("Nikita",4);

            session.beginTransaction();
            session.save(section1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(child1);
            session.save(child2);
            session.save(child3);


            session.getTransaction().commit();
            System.out.println("Done");

// -------------------------------------------------------------

            //Добавление трех секций, к которым привязан один ребенок
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Voleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Maths");
//
//            Child child1 = new Child("Igor",10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//
//            session.getTransaction().commit();
//            System.out.println("Done");
// -------------------------------------------------------------

            //Вывод в консоль данных про  1 секцию

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done");
// -------------------------------------------------------------

//              Вывод в консоль данных про  1 ребенка
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
//            System.out.println("Done");


            //Удаление из БД
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
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
