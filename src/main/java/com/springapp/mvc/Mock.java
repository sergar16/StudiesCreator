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
        studyMock.setId(1l);
        studyMock.setName("Gaming Mouse");
        Set<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("os_type", "windows"));
        conditions.add(new Condition("device_type", "mouse"));

        Set<DCM> dcms = new HashSet<>();
        dcms.add(new DCM("client_name", "test.values.random", "0:0:0:0:0:10"));
        dcms.add(new DCM("client_version", "test.values.random", "0:0:0:0:0:5"));
        dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
        dcms.add(new DCM("analytics_test", "test.values.cycle", "0:0:0:0:0:200"));
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
    }

    public static ArrayList<Key> keys = new ArrayList<>();

    static {
        keys.add(new Key("client_name"));
        keys.add(new Key("os_type"));
        keys.add(new Key("os_version"));
    }

    public static ArrayList<Name> names = new ArrayList<>();
    static {
        names.add(new Name("client_name"));
        names.add(new Name("os_type"));
        names.add(new Name("os_version"));
        names.add(new Name("device_id"));
        names.add(new Name("device_name"));
        names.add(new Name("region_name"));
    }


    public static ArrayList<Value> values=new ArrayList<>();
    static {
        values.add(new Value("windows"));
        values.add(new Value("Linux"));
        values.add(new Value("mac"));
        values.add(new Value("mouse"));
        values.add(new Value("keyboard"));
        values.add(new Value("webcam"));
        values.add(new Value("gameing keyboard"));
        values.add(new Value("wireless dev"));
        values.add(new Value("eu-west-1"));
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

      EntityDAO  entityDAO=DAOFactory.getStudyDAO();
        generateStudies().stream().forEach(entityDAO::save);

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

        entityDAO=DAOFactory.getNamesDAO();
        names.stream().forEach(entityDAO::save);
        entityDAO=DAOFactory.getValuesDAO();
        values.stream().forEach(entityDAO::save);




    }

    public static ArrayList<Study> generateStudies(){
        ArrayList<Study> studies=new ArrayList<>();
        for (int i=1;i<studiesNames.size();i++){
            Study study=new Study();
          study.setName(studiesNames.get(i));
            study.setId(new Long(i));
            Set<Condition> conditions = new HashSet<>();
            conditions.add(new Condition("os_type", "windows"));
            conditions.add(new Condition("device_type", "mouse"));
            conditions.add(new Condition("region", "USA"));
            conditions.add(new Condition("region", "Europe"));

            Set<DCM> dcms = new HashSet<>();
            dcms.add(new DCM("client_name", "test.values.random", "0:0:0:0:0:10"));
            dcms.add(new DCM("client_version", "test.values.random", "0:0:0:0:0:5"));
            dcms.add(new DCM("core_test", "core_test2", "0:0:0:0:0:100"));
            dcms.add(new DCM("analytics_test", "test.values.cycle", "0:0:0:0:0:200"));
            dcms.add(new DCM("analytics_test2", "analytics_test", "0:0:0:0:0:5"));

            for (int j=0;j<Math.random()*dcms.size();j++){
                if (((int) Math.random() * 100) % 2 == 0) {
                   dcms.remove(dcms.iterator().next());
                }
            }
            for (int j=0;j<Math.random()*conditions.size();j++){
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

