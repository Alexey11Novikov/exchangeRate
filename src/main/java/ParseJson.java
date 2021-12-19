import connection.ConnectApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class ParseJson {

    public JSONObject getValute() {
        ConnectApi connectApi = new ConnectApi();
        return (JSONObject)connectApi.parseJson().get("Valute");
    }

    public String getKey() {
        JSONObject jsonObject = getValute();
        Iterator<String> keys = jsonObject.keySet().iterator();

        while(keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
               System.out.println(key);
            }
        }
        return null;
    }
}
