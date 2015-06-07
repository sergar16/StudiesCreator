package db;

import com.springapp.mvc.Mock;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.enabled.Key;

/**
 * Created by Logitech on 03.06.15.
 */
public class Runner {
    public static void main(String[] ar){


       EntityDAO entityDAO= DAOFactory.getKeyDAO();
        entityDAO.save(new Key( "analytics_test"));
        entityDAO.save(new Key( "core_test"));
        entityDAO.findAll().stream().forEach(System.out::println);
        entityDAO=DAOFactory.getStudyDAO();
        entityDAO.save(Mock.studyMock);
        entityDAO.findAll().stream().forEach(System.out::println);

    }
}
