import connection.ConnectApi;
import org.json.simple.JSONObject;

import java.util.*;

public class ParseJson {

    public JSONObject getValute() {
        ConnectApi connectApi = new ConnectApi();
        return (JSONObject)connectApi.parseJson().get("Valute");
    }

    public Map<String, Float> getKey() {
        JSONObject jsonObject = getValute();
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

    public void findBestValute() {
        Map<String, Float> response = getKey();
        List<String> list = new LinkedList<>();
       for(int i=0; i<5; i++) {
           String key = minMax(response);
           response.remove(key);
           list.add(key);
       }
       //Top 5
       System.out.println(list);
    }

    private String minMax(Map<String, Float> map) {
        Float maxValueInMap=(Collections.max(map.values()));  // This will return max value in the HashMap
        for (Map.Entry<String, Float> entry : map.entrySet()) {  // Iterate through HashMap
            if (entry.getValue() == maxValueInMap) {
              return entry.getKey();    // Print the key with max value
            }
        }
        return null;
    }
}
