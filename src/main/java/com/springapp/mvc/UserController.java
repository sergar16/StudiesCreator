package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Logitech on 11.06.15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    static {try{ Mock.init();}catch (Exception ex){
        ex.printStackTrace();}}

    @RequestMapping(value = "/studies",method = RequestMethod.GET)
    public String getall(ModelMap model) {

        EntityDAO entityDAO= DAOFactory.getStudyDAO();
        model.addAttribute("studies", entityDAO.findAll());

        return "studiesList";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable long id, ModelMap model) {

        EntityDAO entityDAO= DAOFactory.getStudyDAO();
        model.addAttribute("study", entityDAO.findById(id));
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
        return "userStudyEditor";
    }
}
