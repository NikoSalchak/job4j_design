package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Employees {
    public static void main(String[] args) {
        Employee employee = new Employee("Name", 26, false,
                new Car("brand", 2020), new String[]{"task1", "task2"});
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(employee));
        String employeeJson =
                "{"
                        + "\"name\": \"Name\","
                        + "\"age\": 26,"
                        + "\"knowsEnglish\": false,"
                        + "\"car\":"
                        + "{"
                        + "\"brand\": \"brand\","
                        + "\"year\": 2020"
                        + "},"
                        + "\"tasks\":"
                        + "[ \"task1\", \"task2\"]"
                        + "}";
        Employee employee1 = gson.fromJson(employeeJson, Employee.class);
        System.out.println(employee1);
    }
}
