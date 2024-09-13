package ru.job4j.designsystem;

public interface Logger {

    String getName();

    void trace(String message);

    void debug(String message);

    void info(String message);

    void warn(String message);

    void error(String message);
}
