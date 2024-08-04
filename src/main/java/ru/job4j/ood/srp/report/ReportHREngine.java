package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sort.EmployeeDescBySalary;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHREngine implements Report {
    private final Store store;
    private final Comparator<Employee> comparator;

    public ReportHREngine(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> salarySortedEmployees = store.findBy(filter)
                .stream()
                .sorted(comparator)
                .toList();
        StringBuilder sb = new StringBuilder();
        sb.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : salarySortedEmployees) {
            sb.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Store store = new MemoryStore();
        Comparator<Employee> comparator = new EmployeeDescBySalary();
        Report report = new ReportHREngine(store, comparator);
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Marina", now, now, 30000D));
        store.add(new Employee("Zaur", now, now, 45000D));
        store.add(new Employee("Dmitriy", now, now, 18499D));
        String rsl = report.generate(employee -> true);
        System.out.println(rsl);
    }
}
