package ru.job4j.designsystem;

import java.time.LocalDateTime;

public class SimpleLogInfo implements LogInfo {
    LocalDateTime dateTime;
    LogLevel logLevel;
    String name;
    String message;

    public SimpleLogInfo(LocalDateTime dateTime, LogLevel logLevel, String name, String message) {
        this.dateTime = dateTime;
        this.logLevel = logLevel;
        this.name = name;
        this.message = message;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SimpleLogInfo{"
                + "dateTime=" + dateTime
                + ", logLevel=" + logLevel
                + ", name='" + name + '\''
                + ", info='" + message + '\''
                + '}';
    }
}
