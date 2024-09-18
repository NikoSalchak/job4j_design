package ru.job4j.designsystem;

import ru.job4j.designsystem.appenders.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        PropertyReader properties = new PropertyReader();
        String[] rootLogger = properties.getRootConfigurations();
        List<Appender> appenderList = new ArrayList<>();
        for (int i = 0; i < rootLogger.length; i++) {
            if ("Console".equals(properties.getProperty("appender.".concat(rootLogger[i])))) {
                int level = getPropertyAppenderLevel(properties.getProperty("appender.".concat(rootLogger[i].concat(".level"))));
                appenderList.add(new ConsoleAppender(level));
            }
            if ("File".equals(properties.getProperty("appender.".concat(rootLogger[i])))) {
                int level = getPropertyAppenderLevel(properties.getProperty("appender.".concat(rootLogger[i].concat(".level"))));
                appenderList.add(new FileAppender(level, properties.getProperty("appender.".concat(rootLogger[i].concat(".file")))));
            }
        }
        return new SimpleLogger(name, appenderList);
    }

    private static int getPropertyAppenderLevel(String appenderLevel) {
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

    static class SimpleLogger implements Logger {
        private String name;

        private List<Appender> appenderList;

        private SimpleLogger(String name, List<Appender> appenderList) {
            this.name = name;
            this.appenderList = appenderList;
        }

        @Override
        public String getName() {
            return this.name;
        }

        private void log(String message, LogLevel logLevel, Throwable e) {
            DateTimeParser dateTimeParser = new LoggerDateTimeParser();
            String logMessage = String.format("%s %s %s - %s", dateTimeParser.parse(LocalDateTime.now()), logLevel.name(), this.name, message);
            for (Appender appender : appenderList) {
                appender.append(new SimpleLogEvent(logMessage, logLevel, e));
            }
        }

        @Override
        public void trace(String message) {
            this.log(message, LogLevel.TRACE, null);
        }

        @Override
        public void trace(String message, Throwable e) {
            this.log(message, LogLevel.TRACE, e);
        }

        @Override
        public void debug(String message) {
            this.log(message, LogLevel.DEBUG, null);
        }

        @Override
        public void debug(String message, Throwable e) {
            this.log(message, LogLevel.DEBUG, e);
        }

        @Override
        public void info(String message) {
            this.log(message, LogLevel.INFO, null);
        }

        @Override
        public void info(String message, Throwable e) {
            this.log(message, LogLevel.INFO, e);
        }

        @Override
        public void warn(String message) {
            this.log(message, LogLevel.WARN, null);
        }

        @Override
        public void warn(String message, Throwable e) {
            this.log(message, LogLevel.WARN, e);
        }

        @Override
        public void error(String message) {
            this.log(message, LogLevel.ERROR, null);
        }

        @Override
        public void error(String message, Throwable e) {
            this.log(message, LogLevel.ERROR, e);
        }
    }
}
