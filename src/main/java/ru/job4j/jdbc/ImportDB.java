package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties config;
    private String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines()
                    .map(s -> s.split(";"))
                    .filter(this::checkString)
                    .forEach(s -> users.add(new User(s[0], s[1])));
        }
        return users;
    }

    private boolean checkString(String[] string) {
        if (string.length != 2 || string[0].isBlank() || string[1].isBlank()) {
            throw new IllegalArgumentException("String must contain the following elements : \"name;email\"");
        }
        return true;
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password")
        )) {
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s("
                        + "id serial primary key,"
                        + "name varchar(255),"
                        + "email varchar(255)"
                        + ");", tableName);
                statement.execute(sqlQuery);
            }
        }
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(name, email) VALUES(?, ?)")
                ) {
                    preparedStatement.setString(1, user.name);
                    preparedStatement.setString(2, user.email);
                    preparedStatement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + ", email='" + email + '\''
                    + '}';
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream input = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(input);
        }
        ImportDB dataBase = new ImportDB(config, "./dump.txt");
        List<User> users = dataBase.load();
        dataBase.createTable("users");
        dataBase.save(users);
    }
}
