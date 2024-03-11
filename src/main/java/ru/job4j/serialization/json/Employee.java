package ru.job4j.serialization.json;

import java.io.Serializable;
import java.util.Arrays;

public class Employee {
    final private String name;
    final private int age;
    final private boolean knowsEnglish;
    final private Car car;
    final private String[] tasks;

    public Employee(String name, int age, boolean knowsEnglish, Car car, String[] tasks) {
        this.name = name;
        this.age = age;
        this.knowsEnglish = knowsEnglish;
        this.car = car;
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", knowsEnglish=" + knowsEnglish
                + ", car=" + car
                + ", tasks=" + Arrays.toString(tasks)
                + '}';
    }
}
