package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("TableEditor.properties")) {
            properties.load(in);
            String driverClass = properties.getProperty("driver_class");
            Class.forName(driverClass);
            String url = properties.getProperty("url");
            String username = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeStatement(String sqlQuery) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s();", tableName);
        executeStatement(sqlQuery);
    }

    public void dropTable(String tableName) {
        String sqlQuery = String.format("DROP TABLE IF EXISTS %s;", tableName);
        executeStatement(sqlQuery);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sqlQuery = String.format("ALTER TABLE %s ADD %s %s;", tableName, columnName, type);
        executeStatement(sqlQuery);
    }

    public void dropColumn(String tableName, String columnName) {
        String sqlQuery = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
        executeStatement(sqlQuery);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sqlQuery = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        executeStatement(sqlQuery);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        try (TableEditor tableEditor = new TableEditor(new Properties())) {
            tableEditor.createTable("table_from_idea");
            System.out.println(tableEditor.getTableScheme("table_from_idea"));
            tableEditor.dropTable("table_from_idea");
            tableEditor.createTable("table_from_idea");
            tableEditor.addColumn("table_from_idea", "last_name", "varchar(255)");
            System.out.println(tableEditor.getTableScheme("table_from_idea"));
            tableEditor.renameColumn("table_from_idea", "last_name", "name");
            tableEditor.addColumn("table_from_idea", "last_name", "varchar(255)");
            System.out.println(tableEditor.getTableScheme("table_from_idea"));
            tableEditor.dropColumn("table_from_idea", "last_name");
            System.out.println(tableEditor.getTableScheme("table_from_idea"));
        }
    }
}
