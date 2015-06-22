package com.springapp.mvc;

import com.springapp.mvc.security.user.User;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import db.dao.StudyDAO;
import entities.Condition;
import entities.DCM;
import entities.Study;
import entities.available.condition.Name;
import entities.available.condition.Value;
import entities.available.dcm.Key;
import entities.available.dcm.SamplingPeriod;
import entities.available.dcm.Source;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Logitech on 02.06.15.
 */
public class Mock {
    public static Study studyMock = new Study();

    static {
        studyMock.setId(1);
        studyMock.setName("Gaming Mouse");
        Set<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("os_type", "windows"));
        conditions.add(new Condition("device_type", "mouse"));

        Set<DCM> dcms = new HashSet<>();
        dcms.add(new DCM("client_name", "test-values-random", "0:0:0:0:0:10"));
        dcms.add(new DCM("client_version", "test-values-random", "0:0:0:0:0:5"));
        dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
        dcms.add(new DCM("analytics_test", "test-values-cycle", "0:0:0:0:0:200"));
        dcms.add(new DCM("analytics_test2", "analytics_test", "0:0:0:0:0:5"));
        studyMock.setDcm(dcms);
        studyMock.setConditions(conditions);


    }

    public static ArrayList<String> studiesNames = new ArrayList<>();

    static {
        studiesNames.add("Mouse Gaming");
        studiesNames.add("Keyboards");
        studiesNames.add("Gamepads");
        studiesNames.add("Europe Mouses");
        studiesNames.add("USA Keyboards and Mouses");
        studiesNames.add("Europe Keyboards for Ipad");
        studiesNames.add("Speakers");
        studiesNames.add("Asia Mouses");
        studiesNames.add("Wireless Devices");
    }

    public static ArrayList<Key> keys = new ArrayList<>();

    static {
        keys.add(new Key("client_name"));
        keys.add(new Key("os_type"));
        keys.add(new Key("os_version"));
    }

    public static ArrayList<Name> names = new ArrayList<>();

    static {
        Name name1 = new Name(1l, "client_name");

        ArrayList<Value> valList = new ArrayList<>();
        valList.add(new Value( "mouse"));
        valList.add(new Value( "gamepad"));
        valList.add(new Value( "webcam"));
        valList.add(new Value( "keyboard"));
        valList.add(new Value( "speakers"));
        name1.setValuesList(valList);
        names.add(name1);
        valList = new ArrayList<>();
        Name name2 = new Name(2l, "os_type");

        valList.add(new Value( "ubuntu  "));
        valList.add(new Value( "windows"));
        valList.add(new Value( "linux"));
        valList.add(new Value( "osx"));
        name2.setValuesList(valList);
        names.add(name2);

        valList = new ArrayList<>();
        Name name3 = new Name(3, "region-code");

        valList.add(new Value( "us-west-1"));
        valList.add(new Value( "us-west-2"));
        valList.add(new Value( "eu-west-1"));
        valList.add(new Value( "eu-west-2"));
        valList.add(new Value( "au-east-3"));
        name3.setValuesList(valList);

        names.add(name3);
        valList = new ArrayList<>();
        Name name4 = new Name(4, "region-name");

        valList.add(new Value( "Asia"));
        valList.add(new Value( "Africa"));
        valList.add(new Value( "Europe"));
        valList.add(new Value( "USA"));
        name4.setValuesList(valList);

        names.add(name4);


    }



    public static void init() {
/*
        EntityDAO entityDAO=DAOFactory.getUserDAO();
        User user1=new User("ksolodkyy","Logitech1234");
        User user2=new User("test","123");
        User user3=new User("test1","111");
        User user4=new User("test2","111");
        User user5=new User("sergar16","111");
        user1.setStudies(generateStudies());
        user2.setStudies(generateStudies());
        user3.setStudies(generateStudies());
        user4.setStudies(generateStudies());
        user5.setStudies(generateStudies());
        entityDAO.save(user1);
        entityDAO.save(user2);
        entityDAO.save(user3);
        entityDAO.save(user4);
        entityDAO.save(user5);*/

        EntityDAO entityDAO = DAOFactory.getStudyDAO();
        generateStudies().stream().forEach(entityDAO::save);

        entityDAO = DAOFactory.getKeyDAO();


        entityDAO.save(new Key(1, "analytics_test"));
        entityDAO.save(new Key(2, "core_test"));
        entityDAO.save(new Key(3, "analytics_test1"));
        entityDAO.save(new Key(4, "core_test2"));
        entityDAO.save(new Key(5, "client_name"));
        entityDAO.save(new Key(6, "core_test"));
        entityDAO.save(new Key(7, "client_version"));


        entityDAO = DAOFactory.getSourceDAO();
//            entityDAO.save(new Source(1,"test.values.random"));
//        entityDAO.save(new Source(2,"test.values.random"));
//        entityDAO.save(new Source(3,"test.mock"));
//        entityDAO.save(new Source(4,"test.values.cycle"));
//        entityDAO.save(new Source(5,"test.string.random"));
        entityDAO.save(new Source(1, "test-values-random"));
        entityDAO.save(new Source(2, "test-values-random"));
        entityDAO.save(new Source(3, "test-mock"));
        entityDAO.save(new Source(4, "test-values-cycle"));
        entityDAO.save(new Source(5, "test-string-random"));


        entityDAO = DAOFactory.getSamplingPeriodDAO();
        entityDAO.save(new SamplingPeriod(1, "0:0:0:0:0:5"));
        entityDAO.save(new SamplingPeriod(2, "0:0:0:0:0:10"));
        entityDAO.save(new SamplingPeriod(3, "0:0:0:0:0:100"));
        entityDAO.save(new SamplingPeriod(4, "0:0:0:0:0:200"));

        entityDAO = DAOFactory.getNamesDAO();
        names.stream().forEach(entityDAO::save);


    }

    public static ArrayList<Study> generateStudies() {
        ArrayList<Study> studies = new ArrayList<>();
        for (int i = 1; i < studiesNames.size(); i++) {
            Study study = new Study();
            study.setName(studiesNames.get(i));
            study.setId(i);
            Set<Condition> conditions = new HashSet<>();
            conditions.add(new Condition("os_type", "windows"));
            conditions.add(new Condition("device_type", "mouse"));
            conditions.add(new Condition("device_type", "mouse"));
            conditions.add(new Condition("device_type", "mouse"));
            conditions.add(new Condition("region", "USA"));
            conditions.add(new Condition("region", "Europe"));

            Set<DCM> dcms = new HashSet<>();
//            dcms.add(new DCM("client_name", "test.values.random", "0:0:0:0:0:10"));
//            dcms.add(new DCM("client_version", "test.values.random", "0:0:0:0:0:5"));
//            dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
//            dcms.add(new DCM("analytics_test", "test.values.cycle", "0:0:0:0:0:200"));
            dcms.add(new DCM("analytics_test2", "analytics_test", "0:0:0:0:0:5"));
            dcms.add(new DCM("client_name", "test-values-random", "0:0:0:0:0:10"));
            dcms.add(new DCM("client_version", "test-values-random", "0:0:0:0:0:5"));
            dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
            dcms.add(new DCM("analytics_test", "test-values-cycle", "0:0:0:0:0:200"));
            dcms.add(new DCM("analytics_test2", "analytics_test", "0:0:0:0:0:5"));


            for (int j = 0; j < Math.random() * dcms.size(); j++) {
                if (((int) Math.random() * 100) % 2 == 0) {
                    dcms.remove(dcms.iterator().next());
                }
            }
            for (int j = 0; j < Math.random() * conditions.size(); j++) {
                if (((int) Math.random() * 100) % 2 == 0) {
                    dcms.remove(conditions.iterator().next());
                }
            }


            study.setDcm(dcms);

            study.setConditions(conditions);
            study.getConditions().stream().forEach(condition -> {
                condition.setName(names.get((int) Math.random() * names.size()).getName());
            });
            studies.add(study);

        }
        return studies;
    }
}

