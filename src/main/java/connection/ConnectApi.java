package connection;

import config.ReadConfigImpl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectApi {
    public String connect() {
        ReadConfigImpl config = new ReadConfigImpl();
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(config.getApiUrl());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public JSONObject parseJson() {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(connect());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
