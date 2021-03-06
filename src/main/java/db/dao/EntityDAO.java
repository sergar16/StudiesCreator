package db.dao;

import db.Connector;
import entities.JPAEntity;
import entities.Study;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public abstract class EntityDAO<T extends JPAEntity> {
    private static Session session;

    public EntityDAO() {

    }

    public abstract List<T> findAll();

    public abstract T findById(final long id);

    public abstract void save(final T jpaEntity);

    public abstract void saveOrUpdate(final T jpaEntity);

    public abstract void update(final T jpaEntity);

    public abstract void delete(final long id);

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
