package db.dao;

import entities.available.dcm.Key;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public class KeyDAO extends EntityDAO<Key> {

    public KeyDAO() {
        super();
    }

    @Override
    public List<Key> findAll() {

       return (List<Key>) super.getSession().createQuery("SELECT c FROM Key c").list();
    }
    @Override
    public Key findById(final Long id) {
        Key find = null;
        for (Key key : findAll()) {
            if (key.getId().equals(id)) {
                find = key;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final Key key) {
        Session session = super.getSession();
        session.beginTransaction();
        session.save(key);
        session.getTransaction().commit();

    }

    @Override
    public void update(final Key key) {
        Session session = super.getSession();
        session.beginTransaction();
        delete(key.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(key);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
       try{
        Key key=findById(id);

        Session session = super.getSession();
        session.beginTransaction();
        session.delete(key);
        session.getTransaction().commit();
       }catch (Exception e){e.printStackTrace();}


    }
}
