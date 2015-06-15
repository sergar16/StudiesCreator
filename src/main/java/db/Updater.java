package db;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import db.dao.DAOFactory;
import db.dao.EntityDAO;
import entities.Condition;
import entities.DCM;
import entities.Study;
import entities.available.condition.Name;
import entities.available.condition.Value;
import entities.available.dcm.Key;
import entities.available.dcm.SamplingPeriod;
import entities.available.dcm.Source;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Logitech on 14.06.15.
 */
public class Updater {
    public static void updateNames(String values) {
        EntityDAO entityDAO = DAOFactory.getNamesDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String namevalue = object.getString("name");
                Name name = null;
                try {
                    name = (Name) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (name == null) {
                    name = new Name(id, namevalue);
                    System.out.println(name);
                } else {
                    name.setName(namevalue);
                    System.out.println(name);
                }
                entityDAO.saveOrUpdate(name);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }


    }

    public static void updateValues(String values) {
        EntityDAO entityDAO = DAOFactory.getValuesDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String namevalue = object.getString("value");
                Value value = null;
                try {
                    value = (Value) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    value = new Value(id, namevalue);
                    System.out.println(value);
                } else {
                    value.setValue(namevalue);
                    System.out.println(value);
                }
                entityDAO.saveOrUpdate(value);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }

    }

    public static void updateKeys(String values) {
        EntityDAO entityDAO = DAOFactory.getKeyDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String keyValue = object.getString("value");
                Key key = null;
                try {
                    key = (Key) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (key == null) {
                    key = new Key(id, keyValue);
                    System.out.println(key);
                } else {
                    key.setKeyValue(keyValue);
                    System.out.println(keyValue);
                }
                entityDAO.saveOrUpdate(key);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }

    }

    public static void updateSources(String values) {
        EntityDAO entityDAO = DAOFactory.getSourceDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String keyValue = object.getString("value");
                Source source = null;
                try {
                    source = (Source) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (source == null) {
                    source = new Source(id, keyValue);
                    System.out.println(source);
                } else {
                    source.setSource(keyValue);
                    System.out.println(keyValue);
                }
                entityDAO.saveOrUpdate(source);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }

    }

    public static void updateSamplingPeriods(String values) {
        EntityDAO entityDAO = DAOFactory.getSamplingPeriodDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String namevalue = object.getString("value");
                SamplingPeriod samplingPeriod = null;
                try {
                    samplingPeriod = (SamplingPeriod) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (samplingPeriod == null) {
                    samplingPeriod = new SamplingPeriod(id, namevalue);
                    System.out.println(samplingPeriod);
                } else {
                    samplingPeriod.setSamplingPeriod(namevalue);
                    System.out.println(samplingPeriod);
                }
                entityDAO.saveOrUpdate(samplingPeriod);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }
    }

    public static void updateStudies(String values) {
        EntityDAO entityDAO = DAOFactory.getStudyDAO();
        try {
            System.out.println(values);
            JSONArray array = new JSONArray(values);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final long id = Long.parseLong(object.getString("id"));
                final String namevalue = object.getString("value");
                Study study = null;
                try {
                    study = (Study) entityDAO.findById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (study == null) {
                    study = new Study(id, namevalue);
                    System.out.println(study);
                    Set<DCM> dcms = new HashSet<>();
                    dcms.add(new DCM("new", "new", "new"));
                    Set<Condition> conditions = new HashSet<>();
                    conditions.add(new Condition("new", "new"));
                    study.setConditions(conditions);
                    study.setDcm(dcms);
                } else {
                    study.setName(namevalue);
                    System.out.println(study);
                }
                entityDAO.saveOrUpdate(study);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }
    }

    public static void updateStudy(String values, long id) {

        EntityDAO entityDAO = DAOFactory.getStudyDAO();
        System.out.print(values);
        try {
            JSONObject globalObject = new JSONObject(values);

            JSONArray conditionsJSON = globalObject.getJSONArray("conditions");
            JSONArray dcmsJSON = globalObject.getJSONArray("dcm");
            System.out.println(values);
            Set<DCM> dcms = new HashSet<>();
            Set<Condition> conditions = new HashSet<>();

            for (int i = 0; i < dcmsJSON.length(); i++) {
                JSONObject object = dcmsJSON.getJSONObject(i);
                final String key = object.getString("key");
                final String source = object.getString("source");
                final String samplingPeriod = object.getString("sampling");
                dcms.add(new DCM(key, source, samplingPeriod));
            }


            for (int i = 0; i < conditionsJSON.length(); i++) {
                JSONObject object = conditionsJSON.getJSONObject(i);
                System.out.println(object);
                final String name = object.getString("name");
                final String value = object.getString("value");
                conditions.add(new Condition(name, value));
            }

            Study study = null;
            study = (Study) entityDAO.findById(id);
            study.setDcm(dcms);
            study.setConditions(conditions);
            entityDAO.saveOrUpdate(study);

        } catch (JSONException jse) {
            jse.printStackTrace();
        }
    }

}
