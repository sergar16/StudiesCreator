package db.dao;

import com.springapp.mvc.security.user.User;
import entities.Study;
import entities.available.condition.Name;
import entities.available.condition.Value;
import entities.available.dcm.Key;
import entities.available.dcm.SamplingPeriod;
import entities.available.dcm.Source;

/**
 * Created by Logitech on 03.06.15.
 */
public class DAOFactory {
    public static EntityDAO<User> getUserDAO() {
        return new StudyDAO<User>(User.class);
    }
    public static EntityDAO<Study> getStudyDAO() {
        return new StudyDAO<Study>(Study.class);
    }


    public static EntityDAO<Key> getKeyDAO() {
        return new StudyDAO<Key>(Key.class);
    }

    public static EntityDAO<Source> getSourceDAO() {
        return new StudyDAO<Source>(Source.class);
    }

    public static EntityDAO<SamplingPeriod> getSamplingPeriodDAO() {
        return new StudyDAO<SamplingPeriod>(SamplingPeriod.class);
    }

    public static EntityDAO<Name> getNamesDAO() {
        return new StudyDAO<Name>(Name.class);
    }

    public static EntityDAO<Value> getValuesDAO() {
        return new StudyDAO<Value>(Value.class);
    }


}
