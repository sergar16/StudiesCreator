package com.springapp.mvc.services.admin.dcm;

import db.dao.DAOFactory;
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
@RequestMapping("/service/key")
public class KeyService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getKeyDAO().save(new Key(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long id) {
        DAOFactory.getKeyDAO().delete(id);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Key> update() {
        return DAOFactory.getKeyDAO().findAll();
    }


}
