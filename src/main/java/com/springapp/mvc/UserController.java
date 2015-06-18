package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by Logitech on 11.06.15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    static {try{ Mock.init();}catch (Exception ex){
        ex.printStackTrace();}}

    @RequestMapping(value = "/studies",method = RequestMethod.GET)
    public String getAll(ModelMap model) {

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
        List list=DAOFactory.getNamesDAO().findAll().get(0).getValuesList();

        model.addAttribute("values",list);
        return "userStudyEditor";
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(String userId) {
            super("could not find user '" + userId + "'.");
        }}
}
