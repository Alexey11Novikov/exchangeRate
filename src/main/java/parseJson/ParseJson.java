package parseJson;
import connection.ConnectApi;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.util.*;

public class ParseJson {

    public JSONObject getValuteJson() {
        ConnectApi connectApi = new ConnectApi();
        return (JSONObject)connectApi.parseJson().get("Valute");
    }

    public Map<String, Float> getKey() {
        JSONObject jsonObject = getValuteJson();
        Map<String, Float> test = new HashMap<>();
        for (Object keyStr : jsonObject.keySet()) {
            Object keyvalue = jsonObject.get(keyStr);
            if (keyvalue instanceof JSONObject) {
               Float value = Float.parseFloat(((JSONObject) keyvalue).get("Value").toString());
               Float prev = Float.parseFloat(((JSONObject) keyvalue).get("Previous").toString());
               test.put(keyStr.toString(), value-prev);
            }
        }
        return test;
    }

    public void findBestValute() throws FileNotFoundException {
        Map<String, Float> response = getKey();
        ResultOut res = new ResultOut();
       for(int i=0; i<5; i++) {
           String key = minMax(response);
           response.remove(key);
           //write top 5 valute
           res.writeResult(key);
       }
    }

    private String minMax(Map<String, Float> map) {
        Float maxValueInMap=(Collections.max(map.values()));  
        for (Map.Entry<String, Float> entry : map.entrySet()) {  
            if (entry.getValue() == maxValueInMap) {
              return entry.getKey();   
            }
        }
        return null;
    }
}
