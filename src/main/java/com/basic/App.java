package com.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell XPS 13");

        Student student = new Student();
        student.setRollNo(1);
        student.setName("John Doe");
        student.setMarks(85);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();
    }

}    