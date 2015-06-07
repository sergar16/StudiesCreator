package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    static {Mock.init();}
        @RequestMapping(value = "/",method = RequestMethod.GET)
        public String getall(ModelMap model) {
            EntityDAO entityDAO= DAOFactory.getStudyDAO();
            model.addAttribute("study", entityDAO.findAll().get(0));
             entityDAO= DAOFactory.getKeyDAO();
            model.addAttribute("enabledKeys",entityDAO.findAll());
            entityDAO= DAOFactory.getSourceDAO();
            model.addAttribute("enabledSources",entityDAO.findAll());
            entityDAO= DAOFactory.getSamplingPeriodDAO();
            model.addAttribute("enabledSamplingPeriods",entityDAO.findAll());

            model.addAttribute("names",Mock.names);
            model.addAttribute("values",Mock.values);
            return "hello";
    }
}