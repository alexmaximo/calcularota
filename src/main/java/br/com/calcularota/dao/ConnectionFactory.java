package br.com.calcularota.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory;

    public ConnectionFactory() {
        super();
        buildEntityManagerFactory();
    }

    public static void buildEntityManagerFactory() {
        if (entityManagerFactory != null) {
            return;
        }
        entityManagerFactory = Persistence.createEntityManagerFactory("entrega_persistence");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void killEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

}
