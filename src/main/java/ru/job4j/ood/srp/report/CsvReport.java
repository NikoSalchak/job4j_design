package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.function.Predicate;

public class CsvReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public CsvReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append("; ")
                    .append(dateTimeParser.parse(employee.getHired())).append("; ")
                    .append(dateTimeParser.parse(employee.getFired())).append("; ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        try (PrintStream output = new PrintStream("./data/EmployeeReport.csv")) {
            output.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Marina", now, now, 30000D));
        store.add(new Employee("Zaur", now, now, 45000D));
        store.add(new Employee("Dmitriy", now, now, 18499D));
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        CsvReport report = new CsvReport(store, dateTimeParser);
        String rsl = report.generate(employee -> true);
        System.out.println(rsl);
    }
}
