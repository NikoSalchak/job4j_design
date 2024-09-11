package ru.job4j.designsystem;

public class LoggerFactory {

    public static Logger getLogger(String name, LogLevel logLevel) {
        return new SimpleLogger(name, logLevel);
    }

    static class SimpleLogger implements Logger {
        private String name;

        private LogLevel logLevel;

        private SimpleLogger(String name, LogLevel logLevel) {
            this.name = name;
            this.logLevel = logLevel;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public LogLevel getLogLevel() {
            return this.logLevel;
        }
    }
}
