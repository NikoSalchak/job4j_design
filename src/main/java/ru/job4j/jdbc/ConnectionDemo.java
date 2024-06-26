package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("data/app.properties");
        config.load();
        String driver = config.value("hibernate.connection.driver_class");
        Class.forName(driver);
        String url = config.value("hibernate.connection.url1");
        String login = config.value("hibernate.connection.username");
        String configPassword = config.value("hibernate.connection.password");
        try (Connection connection = DriverManager.getConnection(url, login, configPassword)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
