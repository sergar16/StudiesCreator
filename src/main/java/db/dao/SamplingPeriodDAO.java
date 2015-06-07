package db.dao;

import entities.enabled.Key;
import entities.enabled.SamplingPeriod;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Logitech on 03.06.15.
 */
public class SamplingPeriodDAO extends EntityDAO<SamplingPeriod>{
    public SamplingPeriodDAO() {
        super();
    }

    @Override
    public List<SamplingPeriod> findAll() {

        return (List<SamplingPeriod>) super.getSession().createQuery("SELECT c FROM SamplingPeriod c").list();
    }
    @Override
    public SamplingPeriod findById(final String id) {
        SamplingPeriod find = null;
        for (SamplingPeriod samplingPeriod : findAll()) {
            if (samplingPeriod.getId().equals(id)) {
                find = samplingPeriod;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final SamplingPeriod samplingPeriod) {
        Session session = super.getSession();
        session.beginTransaction();
        session.save(samplingPeriod);
        session.getTransaction().commit();

    }

    @Override
    public void update(final SamplingPeriod samplingPeriod) {
        Session session = super.getSession();
        session.beginTransaction();
        SamplingPeriod deletedSamplingPeriod = findById(samplingPeriod.getId());
        delete(deletedSamplingPeriod);
        session.getTransaction().commit();
        session.beginTransaction();
        save(samplingPeriod);
        session.getTransaction().commit();
    }

    @Override
    public void delete(SamplingPeriod samplingPeriod) {
        Session session = super.getSession();
        session.beginTransaction();
        session.delete(samplingPeriod);
        session.getTransaction().commit();


    }
}
