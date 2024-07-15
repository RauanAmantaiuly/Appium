package appium.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFile(String filePath) throws IOException {
        return objectMapper.readTree(new File(filePath));
    }
    public static String getConfigValue(String key) throws IOException {
        String filePath = "src/test/resources/config_data/config_test_data.json";
        JsonNode jsonNode = readJsonFile(filePath);
        return jsonNode.get(key).asText();
    }
}

