package db.dao;

import entities.available.condition.Name;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public class NameDAO extends EntityDAO<Name> {

    public NameDAO() {
        super();
    }

    @Override
    public List<Name> findAll() {

       return (List<Name>) super.getSession().createQuery("SELECT c FROM Name c").list();
    }
    @Override
    public Name findById(final Long id) {
        Name find = null;
        for (Name name : findAll()) {
            if (name.getId().equals(id)) {
                find = name;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final Name name) {
        Session session = super.getSession();
        session.beginTransaction();
        session.save(name);
        session.getTransaction().commit();

    }

    @Override
    public void update(final Name name) {
        Session session = super.getSession();
        session.beginTransaction();
        delete(name.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(name);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = super.getSession();
        Name name=findById(id);
        session.beginTransaction();
        session.delete(name);
        session.getTransaction().commit();


    }
}
