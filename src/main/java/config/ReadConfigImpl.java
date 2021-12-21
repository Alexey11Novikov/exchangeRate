package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ReadConfigImpl implements Config {

    private JsonNode readFile() {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.json")) {

            JsonNode json = new ObjectMapper().readTree(inputStream);
            return json;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getApiUrl() {
        return readFile().path("apiURL").asText();
    }

    @Override
    public String getPort() {
        return readFile().path("port").asText();
    }

    @Override
    public String getTime() {
        return readFile().path("timeUnload").asText();
    }
}
