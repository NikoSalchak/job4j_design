package ru.job4j.designsystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader() {
        this.properties = this.getPropertiesConnect();
    }

    private Properties getPropertiesConnect() {
        Properties properties = null;
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("simpleLog.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String[] getRootConfigurations() {
        return this.properties.getProperty("rootLogger").split(", ");
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
