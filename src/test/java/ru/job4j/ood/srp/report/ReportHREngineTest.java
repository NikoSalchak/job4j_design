package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sort.EmployeeDescBySalary;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class ReportHREngineTest {

    @Test
    void whenSortDescEmployeeBySalary() {
        Store store = new MemoryStore();
        Comparator<Employee> comparator = new EmployeeDescBySalary();
        Report report = new ReportHREngine(store, comparator);
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Marina", now, now, 30000D));
        store.add(new Employee("Zaur", now, now, 45000D));
        store.add(new Employee("Dmitriy", now, now, 18499D));
        String rsl = report.generate(employee -> true);
        String newLine = System.lineSeparator();
        String expected =
                "Name; Salary;" + newLine
                + "Zaur 45000.0" + newLine
                + "Marina 30000.0" + newLine
                + "Dmitriy 18499.0" + newLine;
        assertThat(rsl).isEqualTo(expected);
    }
}