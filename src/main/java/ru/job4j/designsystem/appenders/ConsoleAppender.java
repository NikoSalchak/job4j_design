package ru.job4j.designsystem.appenders;

public class ConsoleAppender implements Appender {

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
