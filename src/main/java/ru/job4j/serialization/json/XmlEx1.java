package ru.job4j.serialization.json;

public class XmlEx1 {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), new String[]{"Worker", "Married"});
        final Employee employee = new Employee("Niko", 28, false,
                new Car("Nissan", 2014), new String[]{"task1", "task2"});

    }
}
