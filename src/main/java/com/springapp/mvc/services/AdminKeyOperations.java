package com.springapp.mvc.services;

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
@RequestMapping("/keyOperations")
public class AdminKeyOperations {
    @RequestMapping(value = "/add/{keyValue}", method = RequestMethod.POST)
    public void add(@PathVariable String keyValue) {
        Key key = new Key(keyValue);
        DAOFactory.getKeyDAO().save(key);
    }

    @RequestMapping(value = "/delete/{keyId}", method = RequestMethod.POST)
        public void delete(@PathVariable Long keyId) {
        DAOFactory.getKeyDAO().delete(keyId);
    }

    @RequestMapping(value = "/update/{keyValue}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Key> update() {
        return DAOFactory.getKeyDAO().findAll();
    }


}
