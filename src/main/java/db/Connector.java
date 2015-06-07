package db;


import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Connector {
    static Logger LOG = LoggerFactory.getLogger(Connector.class);


    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() throws Exception{
        if (sessionFactory == null) {

            sessionFactory = new Configuration().configure().buildSessionFactory();

        }
        return sessionFactory;
    }

}

