package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.DateTimeParser;
import ru.job4j.designsystem.LogInfo;
import ru.job4j.designsystem.LoggerDateTimeParser;

public abstract class AppenderOperator {

    public void operate(LogInfo info) {
        Appender appender = createAppender();
        DateTimeParser dateTimeParser = new LoggerDateTimeParser();
        dateTimeParser.parse(info.getDateTime());
        String message = String.format("%s %s %s - %s", dateTimeParser.parse(info.getDateTime()), info.getLogLevel().name(), info.getName(), info.getMessage());
        appender.append(message);
    }

    public abstract Appender createAppender();
}
