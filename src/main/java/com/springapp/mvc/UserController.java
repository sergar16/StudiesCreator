package com.springapp.mvc;

import db.dao.DAOFactory;
import db.dao.EntityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Logitech on 11.06.15.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/studies",method = RequestMethod.GET)
    public String getall(ModelMap model) {

        EntityDAO entityDAO= DAOFactory.getStudyDAO();
        model.addAttribute("studies", entityDAO.findAll());

        return "studieslist";
    }
}
