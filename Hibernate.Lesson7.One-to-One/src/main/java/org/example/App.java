package org.example;

import org.example.model.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.model.Person;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Person person = new Person("Test person", 65);
//            Passport passport = new Passport(person, 12345);
//            person.setPassport(passport);
//            session.persist(person);

//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = session.get(Passport.class,1);
//            System.out.println(passport.getPerson().getName());

//            Person person = session.get(Person.class, 1);
//            person.getPassport().setPassportNumber(777);

            Person person = session.get(Person.class, 1);
            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
