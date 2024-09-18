package ru.job4j.designsystem;

import ru.job4j.designsystem.appenders.*;
import java.time.LocalDateTime;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new SimpleLogger(name);
    }

    static class SimpleLogger implements Logger {
        private String name;

        private AppenderList appenderList;

        private SimpleLogger(String name) {
            this.name = name;
            this.appenderList = new SimpleAppenderList();
        }

        @Override
        public String getName() {
            return this.name;
        }

        private void log(String message, LogLevel logLevel, Throwable e) {
            DateTimeParser dateTimeParser = new LoggerDateTimeParser();
            String logMessage = String.format("%s %s %s - %s", dateTimeParser.parse(LocalDateTime.now()), logLevel.name(), this.name, message);
            for (Appender appender : appenderList.getAppenderList()) {
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
