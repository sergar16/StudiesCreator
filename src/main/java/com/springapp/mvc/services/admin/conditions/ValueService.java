package com.springapp.mvc.services.admin.conditions;

import db.Updater;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.available.condition.Name;
import entities.available.condition.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.JSONProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/value")
public class ValueService {
//    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
//    public void add(@PathVariable String value) {
//        DAOFactory.getValuesDAO().save(new Value(value));
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//        public void delete(@PathVariable Long id) {
//        DAOFactory.getValuesDAO().delete(id);
//    }
//
//    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
//    public void update(@PathVariable String value) {
//    }
//    @RequestMapping(value = "/updateAll/{values}", method = RequestMethod.POST)
//    public void updateAll(@PathVariable String values) {
//        Updater.updateValues(values);
//    }
//    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
//    public List<Value> update() {
//        return DAOFactory.getValuesDAO().findAll();
//    }

    @RequestMapping(value = "/save/{nameid}/{values}", method = RequestMethod.POST)
    public ResponseEntity saveAllByConditionName(@PathVariable long nameid, @PathVariable String values) {
        EntityDAO<Name> entityDAO=DAOFactory.getNamesDAO();
        Name name=entityDAO.findById(nameid);
        name.setValuesList(JSONProcessor.getValuestListFromJSON(values));
        return ResponseEntity.ok(values);
    }

    @RequestMapping(value = "/get/{nameid}", method = RequestMethod.GET)
    public List<Value> getAllByConditionName(@PathVariable long nameid) {
        EntityDAO<Name> entityDAO=DAOFactory.getNamesDAO();
        Name name=entityDAO.findById(nameid);
        return name.getValuesList();
    }

}
