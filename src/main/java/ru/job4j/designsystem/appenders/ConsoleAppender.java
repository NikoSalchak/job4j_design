package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogLevel;
import ru.job4j.designsystem.Logger;

public class ConsoleAppender implements Appender {

    protected Logger logger;

    public ConsoleAppender(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void append(String message) {
        if (LogLevel.TRACE == logger.getLogLevel()) {
            System.out.println(message);
        }
    }
}
