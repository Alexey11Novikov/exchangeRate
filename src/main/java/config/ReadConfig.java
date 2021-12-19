package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ReadConfig {

    private JsonNode readFile() {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.json")) {

            JsonNode json = new ObjectMapper().readTree(inputStream);
            return json;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String getApiUrl() {
        return readFile().path("apiURL").asText();
    }

    public String getPort() {
        return readFile().path("port").asText();
    }
}
