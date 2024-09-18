package ru.job4j.designsystem;

public class SimpleLogEvent implements LogEvent {
    private String message;
    private LogLevel logLevel;
    private Throwable throwable;

    public SimpleLogEvent() {
    }

    public SimpleLogEvent(String message, LogLevel logLevel, Throwable throwable) {
        this.message = message;
        this.logLevel = logLevel;
        this.throwable = throwable;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }
}
