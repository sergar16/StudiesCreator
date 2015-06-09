package db.dao;

import entities.Study;
import org.hibernate.Session;

import java.util.List;

public class StudyDAO extends EntityDAO<Study> {



    public StudyDAO() {
  }

    @Override
    public List<Study> findAll() {
        return (List<Study>) super.getSession().createQuery("SELECT c FROM Study c").list();
    }

    public Study findById(final Long id) {
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
        delete(study.getId());
        session.getTransaction().commit();
        session.beginTransaction();
        save(study);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = super.getSession();
       Study study =findById(id);
        session.beginTransaction();
        session.delete(study);
        session.getTransaction().commit();


    }

}

