package org.example;

import org.example.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.model.Person;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Person person = session.get(Person.class, 3);
//            System.out.println(person.getName());
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            Item item = session.get(Item.class, 5);
//            System.out.println(item.getName());
//            Person person = item.getOwner();
//            System.out.println(person.getName());

//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person);
//            session.persist(newItem);
//            person.getItems().add(newItem);         //если интересно только сохранение в БД, то писать не надо. Достаточно только на owning side
//                                                    //но, Hibernate кеширует данные. Потому, если вызвать этого человека после, в БД может быть всё нормально, но в вызванном объекте связи с Item не будет

//            Person person = new Person("Test person" ,30);
//            Item newItem = new Item("Item from Hibernate 2", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//            session.persist(person);
//            session.persist(newItem);

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            for (Item item : items)
//                session.remove(item);
//            person.getItems().clear();              //тоже из-за хеширования

//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));

            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
