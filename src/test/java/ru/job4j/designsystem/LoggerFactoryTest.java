package ru.job4j.designsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class LoggerFactoryTest {
    private static Logger logger;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        logger = LoggerFactory.getLogger("className");
        System.setOut(new PrintStream(output));
    }

    @Test
    void whenLoggerMessageInfoThenContain() {
        logger.info("some message");
        assertThat(output.toString()).contains("some message");
    }

    @Test
    void whenLoggerMessageDebugThenIsAbsent() {
        logger.debug("some message");
        assertThat(output.toString()).isEmpty();
    }
}