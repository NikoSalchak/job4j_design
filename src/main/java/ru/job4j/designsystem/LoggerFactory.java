package ru.job4j.designsystem;

import ru.job4j.designsystem.appenders.ConsoleAppender;
import ru.job4j.designsystem.appenders.FileAppender;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new SimpleLogger(name);
    }

    static class SimpleLogger implements Logger {
        private String name;
        private Properties properties;

        private SimpleLogger(String name) {
            this.name = name;
            this.properties = getProperties();
        }

        private Properties getProperties() {
            Properties properties = null;
            try (InputStream input = LoggerFactory.class.getClassLoader().getResourceAsStream("simpleLog.properties")) {
                properties = new Properties();
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        }

        @Override
        public String getName() {
            return this.name;
        }

        private String[] getRootConfigurations() {
            return properties.getProperty("rootLogger").split(", ");
        }

        private int getPropertyAppenderLevel(String appenderLevel) {
            int logLevelCounter = 0;
            int rsl = 0;
            for (LogLevel logLvl : LogLevel.values()) {
                if (logLvl.name().equals(appenderLevel)) {
                    rsl = logLevelCounter;
                }
                logLevelCounter++;
            }
            return rsl;
        }

        private void log(String message, LogLevel logLevel) {
            String[] rootLogger = getRootConfigurations();
            for (int i = 0; i < rootLogger.length; i++) {
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formatDateTime = time.format(formatter);
                String logString = String.format("%s %s %s - %s", formatDateTime, logLevel.name(), this.name, message);
                if ("Console".equals(properties.getProperty("appender." + rootLogger[i]))
                        && getPropertyAppenderLevel(properties.getProperty("appender." + rootLogger[i] + ".level")) <= logLevel.ordinal()) {
                    new ConsoleAppender().append(logString);
                }
                if ("File".equals(properties.getProperty("appender." + rootLogger[i]))
                        && getPropertyAppenderLevel(properties.getProperty("appender." + rootLogger[i] + ".level")) <= logLevel.ordinal()) {
                    new FileAppender(properties.getProperty("appender." + rootLogger[i] + ".file")).append(logString);
                }
            }
        }

        @Override
        public void trace(String message) {
            this.log(message, LogLevel.TRACE);
        }

        @Override
        public void debug(String message) {
            this.log(message, LogLevel.DEBUG);
        }

        @Override
        public void info(String message) {
            this.log(message, LogLevel.INFO);
        }

        @Override
        public void warn(String message) {
            this.log(message, LogLevel.WARN);
        }

        @Override
        public void error(String message) {
            this.log(message, LogLevel.ERROR);
        }
    }
}
