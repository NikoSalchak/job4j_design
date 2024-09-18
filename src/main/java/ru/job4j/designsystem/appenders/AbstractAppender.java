package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;
import ru.job4j.designsystem.LogLevel;

public class AbstractAppender implements Appender {
    private int logLevel;



    public AbstractAppender(int logLevel) {
        this.logLevel = logLevel;
    }

    protected boolean validateLevel(LogLevel logLevel) {
        boolean rsl = false;
        if (this.logLevel <= logLevel.ordinal()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void append(LogEvent logEvent) {
        if (validateLevel(logEvent.getLogLevel())) {
            System.out.println(logEvent.getMessage());
            if (logEvent.getThrowable() != null) {
                logEvent.getThrowable().printStackTrace(System.out);
            }
        }
    }
}
