package ru.job4j.designsystem;

public interface LogEvent {

    String getMessage();

    LogLevel getLogLevel();

    Throwable getThrowable();
}
