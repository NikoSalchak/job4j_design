package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;

public interface Appender {

    void append(LogEvent logEvent);
}
