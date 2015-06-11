package com.springapp.mvc.services.admin.conditions;

import db.dao.DAOFactory;
import entities.available.condition.Value;
import entities.available.dcm.Key;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/value")
public class ValueService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getValuesDAO().save(new Value(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long valueId) {
        DAOFactory.getValuesDAO().delete(valueId);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String value) {
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Value> update() {
        return DAOFactory.getValuesDAO().findAll();
    }


}
