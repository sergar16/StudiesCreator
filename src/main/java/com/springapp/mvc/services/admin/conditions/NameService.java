package com.springapp.mvc.services.admin.conditions;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.available.condition.Name;
import entities.available.dcm.Key;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Logitech on 04.06.15.
 */
@RestController
@RequestMapping("/service/name")
public class NameService {
    @RequestMapping(value = "/add/{value}", method = RequestMethod.POST)
    public void add(@PathVariable String value) {
        DAOFactory.getNamesDAO().save(new Name(value));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public void delete(@PathVariable Long id) {
        DAOFactory.getNamesDAO().delete(id);
    }

    @RequestMapping(value = "/updateAll/{values}", method = RequestMethod.POST)
    public void updateAll(@PathVariable String values) {
        EntityDAO entityDAO=DAOFactory.getNamesDAO();
      try{
        JSONArray array = new JSONArray(values);
        for(int i=0;i<array.length();i++){
           JSONObject object= array.getJSONObject(i);
            Name name=new Name(object.getString("name"));
            name.setId(new Long(i));
        }
   }catch (JSONException jse){jse.printStackTrace();}

    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public List<Name> update() {
        return DAOFactory.getNamesDAO().findAll();
    }


}
