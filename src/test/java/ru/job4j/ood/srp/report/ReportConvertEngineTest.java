package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportConvertEngineTest {

    @Test
    void whenMarinaSalaryRubConvertToUsd() {
        Calendar now = Calendar.getInstance();
        Employee marina = new Employee("Marina", now, now, 30000D);
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Store store = new MemoryStore();
        store.add(marina);
        Report convertEngine = new ReportConvertEngine(store, dateTimeParser, converter);
        String rsl = convertEngine.generate(employee -> true);
        String expected = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + marina.getName() + " "
                + dateTimeParser.parse(marina.getHired()) + " "
                + dateTimeParser.parse(marina.getFired()) + " "
                + 360D
                + System.lineSeparator();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenEmployeesSalaryRubConvertToUsd() {
        Calendar now = Calendar.getInstance();
        String newLine = System.lineSeparator();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Store store = new MemoryStore();
        store.add(new Employee("Marina", now, now, 30000D));
        store.add(new Employee("Zaur", now, now, 45000D));
        store.add(new Employee("Dmitriy", now, now, 18499D));
        Report convertEngine = new ReportConvertEngine(store, dateTimeParser, converter);
        String rsl = convertEngine.generate(employee -> true);
        String expected =
                "Name; Hired; Fired; Salary;" + newLine
                        + "Marina " + dateTimeParser.parse(now) + " " + dateTimeParser.parse(now) + " 360.0" + newLine
                        + "Zaur " + dateTimeParser.parse(now) + " " + dateTimeParser.parse(now) + " 540.0" + newLine
                        + "Dmitriy " + dateTimeParser.parse(now) + " " + dateTimeParser.parse(now) + " 221.988" + newLine;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenDmitriySalaryRubConvertToUsd() {
        Calendar now = Calendar.getInstance();
        Employee dmitriy = new Employee("Dmitriy", now, now, 18499);
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Store store = new MemoryStore();
        store.add(dmitriy);
        Report convertEngine = new ReportConvertEngine(store, dateTimeParser, converter);
        String rsl = convertEngine.generate(employee -> true);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(dmitriy.getName()).append(" ")
                .append(dateTimeParser.parse(dmitriy.getHired())).append(" ")
                .append(dateTimeParser.parse(dmitriy.getFired())).append(" ")
                .append(221.988)
                .append(System.lineSeparator());
        assertThat(rsl).isEqualTo(expected.toString());
    }
}