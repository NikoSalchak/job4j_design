package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Employees {
    public static void main(String[] args) throws JAXBException {
        Employee employee = new Employee("Niko", 27, false,
                new Car("VAZ", 2000), new String[]{"task3", "task4"});
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (FileWriter writer = new FileWriter("./data/JaxbEmployee.xml");
             FileReader reader = new FileReader("./data/JaxbEmployee.xml")) {
            marshaller.marshal(employee, writer);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employee result = (Employee) unmarshaller.unmarshal(reader);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
