package util;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import entities.JPAEntity;
import entities.available.condition.Value;
import entities.available.dcm.Source;
import exceptions.InvalidJSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logitech on 17.06.15.
 */
public class JSONProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(JSONProcessor.class);

    public static List<Value> getValuestListFromJSON(final String json) throws InvalidJSONException {
        try {
            ArrayList<Value> valueList=new ArrayList();
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                final String keyValue = object.getString("value");
                valueList.add(new Value(keyValue));
            }
            return valueList;
        } catch (JSONException jsne) {
            throw new InvalidJSONException(jsne);
        }
    }

//    public static <T> List<T extends JPAEntity> getJPAENtitytListFromJSON(final String json) throws InvalidJSONException {
//        try {
//            ArrayList<T> valueList=new ArrayList();
//            JSONArray array = new JSONArray(json);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject object = array.getJSONObject(i);
//                final String keyValue = object.getString("value");
//                valueList.add(new T(keyValue));
//            }
//            return valueList;
//        } catch (JSONException jsne) {
//            throw new InvalidJSONException(jsne);
//        }
//    }

}