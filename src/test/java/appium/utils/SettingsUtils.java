package appium.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SettingsUtils {
    private static final String SETTINGS_FILE = "src/test/resources/settings.json";
    private static JsonNode settings;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            settings = objectMapper.readTree(new File(SETTINGS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load settings from " + SETTINGS_FILE);
        }
    }

    public static String getAppPackage() {
        return settings.path("driverSettings")
                .path("android")
                .path("capabilities")
                .path("appPackage")
                .asText();
    }
}

