package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean knowsEnglish;
    @XmlElement(name = "car")
    private Car car;
    @XmlElementWrapper(name = "tasks")
    private String[] tasks;

    public Employee() {
    }

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

    public static void main(String[] args) throws JAXBException {
        final Employee employee = new Employee("Niko", 25, false,
                new Car("VAZ", 2000), new String[]{"task3", "task4"});
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
