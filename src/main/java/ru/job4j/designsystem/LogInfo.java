package ru.job4j.designsystem;

import java.time.LocalDateTime;

public interface LogInfo {

    LocalDateTime getDateTime();

    LogLevel getLogLevel();

    String getName();

    String getMessage();
}
