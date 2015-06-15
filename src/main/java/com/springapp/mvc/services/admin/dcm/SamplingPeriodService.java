package com.springapp.mvc.services.admin.dcm;

import db.Updater;
import db.dao.DAOFactory;
import entities.available.dcm.SamplingPeriod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/samplingPeriod")
public class SamplingPeriodService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getSamplingPeriodDAO().save(new SamplingPeriod(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long id) {
        DAOFactory.getSamplingPeriodDAO().delete(id);
    }

    @RequestMapping(value = "/update/{value}", method = RequestMethod.POST)
    public void update(@PathVariable String keyValue) {
    }
    @RequestMapping(value = "/updateAll/{values}", method = RequestMethod.POST)
    public void updateAll(@PathVariable String values) {
        Updater.updateSamplingPeriods(values);
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<SamplingPeriod> update() {
        return DAOFactory.getSamplingPeriodDAO().findAll();
    }


}
