package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;
import ru.job4j.designsystem.LogLevel;
import ru.job4j.designsystem.PropertyReader;

public class AbstractAppender implements Appender {
    protected PropertyReader properties = new PropertyReader();

    private int getPropertyAppenderLevel(String appenderLevel) {
        int logLevelCounter = 0;
        int rsl = 0;
        for (LogLevel logLvl : LogLevel.values()) {
            if (logLvl.name().equals(appenderLevel)) {
                rsl = logLevelCounter;
                break;
            }
            logLevelCounter++;
        }
        return rsl;
    }

    protected boolean validateLevel(String root, LogLevel logLevel) {
        boolean rsl = false;
        if (getPropertyAppenderLevel(properties.getProperty("appender.".concat(root).concat(".level"))) <= logLevel.ordinal()) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void append(LogEvent logEvent) {
        String[] rootLogger = properties.getRootConfigurations();
        for (int i = 0; i < rootLogger.length; i++) {
            if ("Console".equals(properties.getProperty("appender.".concat(rootLogger[i])))
                    && validateLevel(rootLogger[i], logEvent.getLogLevel())) {
                System.out.println(logEvent.getMessage());
                if (logEvent.getThrowable() != null) {
                    logEvent.getThrowable().printStackTrace(System.out);
                }
            }
        }

    }
}
