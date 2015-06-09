package db.dao;

import entities.available.dcm.Source;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public class SourceDAO extends EntityDAO<Source>{
    public SourceDAO() {
        super();
    }

    @Override
    public List<Source> findAll() {

        return (List<Source>) super.getSession().createQuery("SELECT c FROM Source c").list();
    }
    @Override
    public Source findById(final Long id) {
        Source find = null;
        for (Source samplingPeriod : findAll()) {
            if (samplingPeriod.getId().equals(id)) {
                find = samplingPeriod;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final Source source) {
        Session session = super.getSession();
        session.beginTransaction();
        session.save(source);
        session.getTransaction().commit();

    }

    @Override
    public void update(final Source source) {
        Session session = super.getSession();
        session.beginTransaction();
        delete(source.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(source);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = super.getSession();
        Source source=findById(id);
        session.beginTransaction();
        session.delete(source);
        session.getTransaction().commit();


    }
}
