package com.springapp.mvc.services.admin.dcm;

import db.dao.DAOFactory;
import entities.available.dcm.Key;
import entities.available.dcm.Source;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/source")
public class SourceService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getSourceDAO().save(new Source(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long id) {
        DAOFactory.getSourceDAO().delete(id);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Source> update() {
        return DAOFactory.getSourceDAO().findAll();
    }


}
