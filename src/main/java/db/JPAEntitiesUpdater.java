package db;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.JPAEntity;
import entities.available.condition.Value;
import entities.available.dcm.Key;

/**
 * Created by Logitech on 15.06.15.
 */
public class JPAEntitiesUpdater {
    public static  <T extends JPAEntity> void updateAllValues(String values,Class<T> clazz){
//        EntityDAO entityDAO=null;
//
//        EntityDAO entityDAO = DAOFactory.getValuesDAO();
//        try {
//            System.out.println(values);
//            JSONArray array = new JSONArray(values);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject object = array.getJSONObject(i);
//                final long id = Long.parseLong(object.getString("id"));
//                final String namevalue = object.getString("value");
//
//
//                T t = null;
//                try {
//                    t = (T) entityDAO.findById(id);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if (value == null) {
//                    value = new Value(id, namevalue);
//                    System.out.println(value);
//                } else {
//                    value.setValue(namevalue);
//                    System.out.println(value);
//                }
//                entityDAO.saveOrUpdate(value);
//            }
//        } catch (JSONException jse) {
//            jse.printStackTrace();
//        }
   }
}

