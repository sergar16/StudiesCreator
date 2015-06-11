package db.dao;

import com.springapp.mvc.Mock;
import db.Connector;
import entities.JPAEntity;
import entities.Study;
import entities.available.dcm.Key;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StudyDAO<T extends JPAEntity>  extends EntityDAO<T> {


    private static Session session;
    static { try {
        session = Connector.getSessionFactory().openSession();
    } catch (Exception ex) {
        ex.printStackTrace();
    }}
    public StudyDAO(Class<T> type) {
        this.type = type;
    }



    public List<T> findAll() {
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    public T findById(final Long id) {
      return findAll().stream().filter(t -> t.getId().equals(id)).findFirst().get();

    }


    public void save(final T t) {

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

    }

    public void update(final T t) {
        session.beginTransaction();
        delete(t.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(t);
        session.getTransaction().commit();
    }


    public void delete(Long id) {
       T t =findById(id);
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();


    }

    public static void main(String[] a) {
        Mock.init();
        System.out.print(new StudyDAO<Key>(Key.class).findAll());
    }
    private final Class<T> type;


    public Class<T> getMyType() {
        return this.type;
    }

}

