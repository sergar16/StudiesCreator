package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Logitech on 02.06.15.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/edit/dcm", method = RequestMethod.GET)
    public String editDCM(ModelMap model) {
        EntityDAO entityDAO= DAOFactory.getKeyDAO();
        model.addAttribute("keys", entityDAO.findAll());
         entityDAO= DAOFactory.getSourceDAO();
        model.addAttribute("sources", entityDAO.findAll());
        entityDAO= DAOFactory.getSamplingPeriodDAO();
        model.addAttribute("samplingPeriods", entityDAO.findAll());
        return "adminDCMEditor";
    }

    @RequestMapping(value = "/edit/conditions", method = RequestMethod.GET)
    public String editConditions(ModelMap model) {
        EntityDAO entityDAO= DAOFactory.getNamesDAO();
        model.addAttribute("names", entityDAO.findAll());
        entityDAO= DAOFactory.getValuesDAO();
        model.addAttribute("values", entityDAO.findAll());
        return "adminConditionEditor";
    }

}
