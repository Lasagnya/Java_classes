package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            Director director1 = session.get(Director.class, 3);
//            List<Movie> movies1 = director1.getMovies();

//            Movie movie2 = session.get(Movie.class, 5);
//            Director director2 = movie2.getDirector();

//            Director director3 = session.get(Director.class, 5);
//            Movie movie3 = new Movie("Test", 2000, director3);
//            session.persist(movie3);
//            director3.getMovies().add(movie3);

//            Director director4 = new Director("Anonym", 15);
//            Movie movie4 = new Movie("Anonym's film", 2023, director4);
//            director4.setMovies(Collections.singletonList(movie4));
//            session.persist(director4);

//            Movie movie5 = session.get(Movie.class, 12);
//            Director director5 = session.get(Director.class, 4);
//            movie5.getDirector().getMovies().remove(movie5);
//            movie5.setDirector(director5);
//            director5.getMovies().add(movie5);

            Movie movie6 = session.get(Movie.class, 12);
            Director director6 = movie6.getDirector();
            director6.getMovies().remove(movie6);
            session.remove(movie6);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
