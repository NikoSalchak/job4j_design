package ru.job4j.designsystem.appenders;

import java.util.Arrays;
import java.util.List;

public class SimpleAppenderList implements AppenderList {

    private List<Appender> list;

    public SimpleAppenderList() {
        this.list = Arrays.asList(new ConsoleAppender(), new FileAppender());
    }

    @Override
    public List<Appender> getAppenderList() {
        return this.list;
    }
}
