package org.example;

import logger.LogLevel;
import logger.Logger;
import logger.LoggerFactory;
import logger.SpyLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelFilteredLoggerTest {

    @Test
    void shouldFilterMessagesBelowMinLevel() {
        SpyLogger spy = new SpyLogger();
        Logger filtered = LoggerFactory.withMinLevel(spy, LogLevel.WARN);

        filtered.log(LogLevel.INFO, "info");
        filtered.log(LogLevel.WARN, "warn");
        filtered.log(LogLevel.ERROR, "error");

        assertEquals(2, spy.entries().size());
        assertTrue(spy.entries().get(0).contains("[WARN]"));
        assertTrue(spy.entries().get(1).contains("[ERROR]"));
    }
}
