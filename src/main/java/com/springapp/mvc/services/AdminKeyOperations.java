package com.springapp.mvc.services;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.enabled.Key;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/keyOperations")
public class AdminKeyOperations {
    @RequestMapping(value = "/addkey/{keyValue}", method = RequestMethod.GET)
    public void add(@PathVariable String keyValue) {
       Key key=new Key(keyValue);
        DAOFactory.getKeyDAO().save(key);
    }

}
