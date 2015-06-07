package db.dao;

import db.Connector;
import entities.Study;
import entities.enabled.Key;
import org.hibernate.Session;

import java.util.List;

public class StudyDAO extends EntityDAO<Study> {



    public StudyDAO() {
  }

    @Override
    public List<Study> findAll() {
        return (List<Study>) super.getSession().createQuery("SELECT c FROM Study c").list();
    }

    public Study findById(final String id) {
        Study find = null;
        for (Study Study : findAll()) {
            if (Study.getId().equals(id)) {
                find = Study;
                break;
            }
        }
        return find;
    }

    @Override
    public void save(final Study study) {
        Session session = super.getSession();

        session.beginTransaction();
        session.save(study);
        session.getTransaction().commit();

    }

    @Override
    public void update(final Study study) {
        Session session = super.getSession();
        session.beginTransaction();
        Study deletedStudy = findById(study.getId());
        delete(deletedStudy);
        session.getTransaction().commit();
        session.beginTransaction();
        save(study);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Study study) {
        Session session = super.getSession();
        session.beginTransaction();
        session.delete(study);
        session.getTransaction().commit();


    }

}

