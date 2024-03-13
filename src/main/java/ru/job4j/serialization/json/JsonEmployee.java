package ru.job4j.serialization.json;

import org.json.JSONObject;

public class JsonEmployee {
    public static void main(String[] args) {
        Car car = new Car("VAZ", 2011);
        JSONObject jsonCar = new JSONObject("{\"brand\":\"VAZ\", \"year\":\"2011\"}");
        System.out.println("car:" + jsonCar);
        Employee employee = new Employee("Niko", 28, true, car, new String[]{"task2, task3"});
        JSONObject jsonEmployee = new JSONObject();
        jsonEmployee.put("name", employee.getName());
        jsonEmployee.put("age", employee.getAge());
        jsonEmployee.put("knowsEnglish", employee.isKnowsEnglish());
        jsonEmployee.put("car", jsonCar);
        jsonEmployee.put("tasks", employee.getTasks());
        System.out.println(jsonEmployee);
        System.out.println(new JSONObject(employee));
        JSONObject jsonObject = new JSONObject("{\"name\":\"name\", \"year\":\"1995\", \"knownEnglish\":\"true\", "
                + "\"car\":{\"brand\":\"VAZ\", \"year\":\"2011\"}, \"tasks\":[\"task4, task5\"]}");
        System.out.println(jsonObject);

    }
}
