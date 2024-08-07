package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.StringWriter;

import java.util.function.Predicate;

public class XmlReport implements Report {
    private Store store;
    private Marshaller marshaller;

    public XmlReport(Store store) {
        this.store = store;
        this.marshaller = getMarshaller();
    }

    private Marshaller getMarshaller() {
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String rsl = "";
        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : store.findBy(employee -> true)) {
                marshaller.marshal(employee, writer);
            }
            rsl = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
