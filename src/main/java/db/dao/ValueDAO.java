package db.dao;

import entities.available.condition.Value;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public class ValueDAO extends EntityDAO<Value> {

    public ValueDAO() {
        super();
    }

    @Override
    public List<Value> findAll() {

       return (List<Value>) super.getSession().createQuery("SELECT c FROM Value c").list();
    }
    @Override
    public Value findById(final Long id) {
        Value find = null;
        for (Value value : findAll()) {
            if (value.getId().equals(id)) {
                find = value;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final Value value) {
        Session session = super.getSession();
        session.beginTransaction();
        session.save(value);
        session.getTransaction().commit();

    }

    @Override
    public void update(final Value value) {
        Session session = super.getSession();
        session.beginTransaction();
        delete(value.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(value);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = super.getSession();
        Value value=findById(id);
        session.beginTransaction();
        session.delete(value);
        session.getTransaction().commit();


    }
}
