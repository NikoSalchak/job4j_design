package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogLevel;

public class ConsoleAppender extends AbstractAppender {

    @Override
    public void append(String message, LogLevel logLevel) {
        super.append(message, logLevel);
    }
}
