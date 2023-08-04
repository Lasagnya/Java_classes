package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.model.Person;
import org.hibernate.query.Query;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            //List<Person> people = session.createQuery("from Person where age > 30", Person.class).list();
            //List<Person> people = session.createQuery("from Person where name like 'T%'", Person.class).list();
            //Query<Person> query = session.createQuery("update Person set name='Test' where age < 30");
            Query<Person> query = session.createQuery("delete Person where age < 30");
            int count = query.executeUpdate();
//            for (Person person : people)
//                System.out.println(person.getName());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
