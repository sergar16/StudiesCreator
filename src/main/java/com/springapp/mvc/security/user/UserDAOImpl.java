package com.springapp.mvc.security.user;


import java.util.ArrayList;
import java.util.List;

import db.Connector;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {


    static private SessionFactory sessionFactory;
    static {try{sessionFactory=Connector.getSessionFactory();}catch (Exception ex){}}

    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

}