package ru.job4j.designsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerDateTimeParser implements DateTimeParser {

    @Override
    public String parse(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
