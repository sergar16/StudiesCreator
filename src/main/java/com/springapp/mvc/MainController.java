package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import db.dao.StudyDAO;
import entities.Study;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/study")
public class MainController {

    static {try{ Mock.init();}catch (Exception ex){
        ex.printStackTrace();}}
        @RequestMapping(value = "/edit",method = RequestMethod.GET)
        public String getall(ModelMap model) {

            EntityDAO entityDAO= DAOFactory.getStudyDAO();
            model.addAttribute("study", entityDAO.findAll().get(0));
             entityDAO= DAOFactory.getKeyDAO();
            model.addAttribute("enabledKeys",entityDAO.findAll());
            entityDAO= DAOFactory.getSourceDAO();
            model.addAttribute("enabledSources",entityDAO.findAll());
            entityDAO= DAOFactory.getSamplingPeriodDAO();
            model.addAttribute("enabledSamplingPeriods",entityDAO.findAll());
            entityDAO= DAOFactory.getNamesDAO();
            model.addAttribute("names",entityDAO.findAll());
            entityDAO=DAOFactory.getValuesDAO();

            model.addAttribute("values",entityDAO.findAll());
            return "userstudyeditor";
    }
}