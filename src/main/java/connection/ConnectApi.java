package connection;

import config.ReadConfig;

import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectApi {
    private void connect() {
        ReadConfig config = new ReadConfig();
        try {
            URL url = new URL(config.getApiUrl());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
