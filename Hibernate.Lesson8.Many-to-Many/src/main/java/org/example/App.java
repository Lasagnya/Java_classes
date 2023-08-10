package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//            movie.setActors(List.of(actor1, actor2));
//            actor1.setMovies(Collections.singletonList(movie));
//            actor2.setMovies(Collections.singletonList(movie));
//            session.persist(movie);
//            session.persist(actor1);
//            session.persist(actor2);

//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());

//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(Collections.singletonList(actor));
//            actor.getMovies().add(movie);
//            session.persist(movie);

            Actor actor = session.get(Actor.class, 2);
            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}
