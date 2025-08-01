package com.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell XPS 25");
        // Assuming a many-to-many relationship, we can set the student for the laptop
        // If you want to establish a relationship, you would typically add the student to the laptop's list
        // laptop.getStudent().add(student); // Assuming Laptop has a field for Student
        // And set the laptop in the student if needed (not shown in Student class)
        // student.getLaptops().add(laptop); // Assuming Student has a field for List<Laptop>


        Student student = new Student();
        student.setRollNo(1);
        student.setName("John Doe");
        student.setMarks(85);
        // Assuming a one-to-many relationship, we can set the laptop for the student
        // If you want to establish a relationship, you would typically add the laptop to the student's list
        student.getLaptops().add(laptop);
        // If Laptop can belong to multiple students, you would add the student to the laptop's list
        // If Laptop belongs to one student, you would set the student in the laptop
        laptop.getStudent().add(student);
        // And set the student in the laptop if needed (not shown in Laptop class)
        // laptop.setStudent(student); // Assuming Laptop has a field for Student
        // student.setLaptop(laptop);

        // Hibernate configuration

        Configuration configuration = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Laptop.class)
            .addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry = configuration
            .getStandardServiceRegistryBuilder()
            .build();

        SessionFactory sessionFactory = configuration
            .buildSessionFactory(serviceRegistry);
        Session session = sessionFactory
            .openSession();

        session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();
    }

}    