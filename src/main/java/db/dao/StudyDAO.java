package db.dao;

import com.springapp.mvc.Mock;
import db.Connector;
import entities.JPAEntity;
import entities.Study;
import entities.available.dcm.Key;
import exceptions.NoSuchElementException;
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

    public T findById(final long id) throws NoSuchElementException{
      Optional<T> optional= findAll().stream().filter(t -> t.getId() == id).findFirst();
       if(optional.isPresent()){return optional.get();}
        throw new NoSuchElementException();
    }


    public void save(final T t) {

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

    }
    public void saveOrUpdate(final T t) {
    try {
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
    }catch (Exception ex){}
    }

    public void update(final T t) {
//        session.beginTransaction();
//       try{
//        delete(t.getId());}catch (Exception ex){}
//        session.getTransaction().commit();
//        session.beginTransaction();
//        save(t);
//        session.getTransaction().commit();
        session.update(t);
    }


    public void delete(long id) {
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

