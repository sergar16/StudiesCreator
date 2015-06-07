package db.dao;

/**
 * Created by Logitech on 03.06.15.
 */
public class DAOFactory {
    public static EntityDAO getStudyDAO() {
        return new StudyDAO();
    }

    public static EntityDAO getKeyDAO() {
        return new KeyDAO();
    }

    public static EntityDAO getSourceDAO() {
        return new SourceDAO();
    }

    public static EntityDAO getSamplingPeriodDAO() {
        return new SamplingPeriodDAO();
    }


}
