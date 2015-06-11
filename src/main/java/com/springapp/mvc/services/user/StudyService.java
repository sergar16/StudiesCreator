package com.springapp.mvc.services.user;

import db.dao.DAOFactory;
import entities.Study;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long id) {
        DAOFactory.getStudyDAO().delete(id);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Study> update() {
        return DAOFactory.getStudyDAO().findAll();
    }


}
