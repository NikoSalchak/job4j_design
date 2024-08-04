package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class CsvReportTest {

    @Test
    void whenReportToCsv(@TempDir Path tempDir) throws IOException {
        File target = tempDir.resolve("output.csv").toFile();
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        store.add(new Employee("Marina", now, now, 30000D));
        store.add(new Employee("Zaur", now, now, 45000D));
        store.add(new Employee("Dmitriy", now, now, 18499D));
        CsvReport csvReport = new CsvReport(store, dateTimeParser);
        csvReport.generate(employee -> true);
        String newLine = System.lineSeparator();
        String data =
                "Name; Hired; Fired; Salary;" + newLine
                        + "Marina; " + dateTimeParser.parse(now) + "; " + dateTimeParser.parse(now) + "; 30000.0" + newLine
                        + "Zaur; " + dateTimeParser.parse(now) + "; " + dateTimeParser.parse(now) + "; 45000.0" + newLine
                        + "Dmitriy; " + dateTimeParser.parse(now) + "; " + dateTimeParser.parse(now) + "; 18499.0" + newLine;
        Files.writeString(target.toPath(), data);
        assertThat(Files.readString(Path.of("./data/EmployeeReport.csv"))).isEqualTo(Files.readString(target.toPath()));
    }
}