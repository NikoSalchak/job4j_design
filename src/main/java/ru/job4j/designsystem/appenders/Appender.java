package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogLevel;

public interface Appender {

    void append(String message, LogLevel logLevel);
}
