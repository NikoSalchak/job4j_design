package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;

public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(int logLevel) {
        super(logLevel);
    }

    @Override
    public void append(LogEvent logEvent) {
        super.append(logEvent);
    }
}
