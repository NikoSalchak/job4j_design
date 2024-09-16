package ru.job4j.designsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class LoggerFactoryTest {
    private static Logger LOGGER;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        LOGGER = LoggerFactory.getLogger("className");
        System.setOut(new PrintStream(output));
    }

    @Test
    void whenLoggerMessageInfoThenContain() {
        LOGGER.info("some message");
        assertThat(output.toString()).contains("some message");
    }

    @Test
    void whenLoggerMessageDebugThenIsAbsent() {
        LOGGER.debug("some message");
        assertThat(output.toString()).isEmpty();
    }
}