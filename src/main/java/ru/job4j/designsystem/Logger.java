package ru.job4j.designsystem;

public interface Logger {

    String getName();

    void trace(String message);

    void trace(String message, Throwable e);

    void debug(String message);

    void debug(String message, Throwable e);

    void info(String message);

    void info(String message, Throwable e);

    void warn(String message);

    void warn(String message, Throwable e);

    void error(String message);

    void error(String message, Throwable e);
}
