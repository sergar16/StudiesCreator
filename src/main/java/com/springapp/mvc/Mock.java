package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.Condition;
import entities.DCM;
import entities.Study;
import entities.enabled.Key;
import entities.enabled.SamplingPeriod;
import entities.enabled.Source;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Logitech on 02.06.15.
 */
public class Mock {
    public static Study studyMock = new Study();

    static {
        studyMock.setId("1");
        Set<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("os_type", "windows"));
        conditions.add(new Condition("device_type", "mouce"));

        Set<DCM> dcms = new HashSet<>();
        dcms.add(new DCM("client_name", "test.values.random", "0:0:0:0:0:10"));
        dcms.add(new DCM("client_version", "test.values.random", "0:0:0:0:0:5"));
        dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
        dcms.add(new DCM("analytics_test", "test.values.cycle", "0:0:0:0:0:200"));
        dcms.add(new DCM("analytics_test2", "analytics_test", "0:0:0:0:0:5"));
        studyMock.setDcm(dcms);
        studyMock.setConditions(conditions);


    }


    public static ArrayList<Key> keys = new ArrayList<>();

    static {
        keys.add(new Key("client_name"));
        keys.add(new Key("os_type"));
        keys.add(new Key("os_version"));
    }

    public static ArrayList<String> names = new ArrayList<>();
    static {
        names.add("client_name");
        names.add("os_type");
        names.add("os_version");
    }


    public static ArrayList<String> values=new ArrayList<>();
    static {
        values.add("windows");
        values.add("mouse");
        values.add("mac");
    }

    public static void init() {
        EntityDAO entityDAO=DAOFactory.getStudyDAO();
        entityDAO.save(studyMock);
         entityDAO= DAOFactory.getKeyDAO();
            entityDAO.save(new Key( "analytics_test"));
            entityDAO.save(new Key( "core_test"));
            entityDAO.save(new Key( "analytics_test1"));
            entityDAO.save(new Key( "core_test2"));
        entityDAO.save(new Key("client_name"));
        entityDAO.save(new Key("core_test"));
        entityDAO.save(new Key("client_version"));



        entityDAO= DAOFactory.getSourceDAO();
            entityDAO.save(new Source("test.values.random"));
        entityDAO.save(new Source("test.values.random"));
        entityDAO.save(new Source("test.mock"));
        entityDAO.save(new Source("test.values.cycle"));
        entityDAO.save(new Source("test.string.random"));


        entityDAO= DAOFactory.getSamplingPeriodDAO();
        entityDAO.save(new SamplingPeriod("0:0:0:0:0:5"));
        entityDAO.save(new SamplingPeriod("0:0:0:0:0:10"));
        entityDAO.save(new SamplingPeriod("0:0:0:0:0:100"));
        entityDAO.save(new SamplingPeriod("0:0:0:0:0:200"));






    }
}

