package org.example.readProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public Utils() {
    }

    public static java.util.Properties getApplicationProperties() {
        Properties appProperties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            appProperties.load(input);
            return appProperties;
        } catch (IOException e) {
            String message = "Properties file not found";
        }
        return null;
    }

    public static int getProperties(String nameParameters) {
        Properties appProps = getApplicationProperties();
        if (appProps != null && appProps.size() != 0) {
            return Integer.parseInt(appProps.getProperty(nameParameters));
        }
        return 0;
    }
}

