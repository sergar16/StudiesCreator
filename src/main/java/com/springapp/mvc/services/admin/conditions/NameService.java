package com.springapp.mvc.services.admin.conditions;

import db.Updater;
import db.dao.DAOFactory;
import entities.available.condition.Name;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/name")
public class NameService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getNamesDAO().save(new Name(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        DAOFactory.getNamesDAO().delete(id);
    }

    @RequestMapping(value = "/updateAll/{values}", method = RequestMethod.POST)
    public void updateAll(@PathVariable String values) {
        Updater.updateNames(values);

    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Name> update() {
        return DAOFactory.getNamesDAO().findAll();
    }


}
