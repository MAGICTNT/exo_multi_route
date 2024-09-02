package fr.maxime.exo_multi_route.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;

public class SessionFactorySingleton {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static Connection connection = null;
    private static SessionFactorySingleton session;

    private SessionFactorySingleton() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new SessionFactorySingleton();
        }
        return sessionFactory;
    }

    public static void close(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
