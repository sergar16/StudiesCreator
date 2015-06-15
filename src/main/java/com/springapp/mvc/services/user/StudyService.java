package com.springapp.mvc.services.user;

import db.Updater;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.Condition;
import entities.DCM;
import entities.Study;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/study")
public class StudyService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        //TODO
        DAOFactory.getStudyDAO().save(new Study());
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.POST)
    public void add() {
        EntityDAO entityDAO=DAOFactory.getStudyDAO();

        Study study = new Study(entityDAO.findAll().size()+1, "enter new item");
        System.out.println(study);
        Set<DCM> dcms = new HashSet<>();
        dcms.add(new DCM("new", "new", "new"));
        Set<Condition> conditions = new HashSet<>();
        conditions.add(new Condition("new", "new"));
        study.setConditions(conditions);
        study.setDcm(dcms);
        entityDAO.saveOrUpdate(study);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        DAOFactory.getStudyDAO().delete(id);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }

    @RequestMapping(value = "/updateAll/{values}", method = RequestMethod.POST)
    public void updateAll(@PathVariable String values) {
        Updater.updateStudies(values);
    }

    @RequestMapping(value = "/update/{id}/{values}", method = RequestMethod.POST)

    public void updateStudy(@PathVariable long id, @PathVariable String values) {
        Updater.updateStudy(values, id);
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Study> update() {
        return DAOFactory.getStudyDAO().findAll();
    }

}
