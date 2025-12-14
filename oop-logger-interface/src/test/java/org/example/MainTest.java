package org.example;

import logger.LogLevel;
import logger.Logger;
import logger.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void consoleWarnShouldFilterOutInfoButAllowError() {
        Logger console = LoggerFactory.withMinLevel(LoggerFactory.console(), LogLevel.WARN);

        assertDoesNotThrow(() -> console.log(LogLevel.INFO, "should be filtered"));
        assertDoesNotThrow(() -> console.log(LogLevel.ERROR, "should be printed"));
    }

    @Test
    void fileInfoShouldBeWrittenButWarnFilterShouldBlockInfo() throws Exception {
        Path tmp = Files.createTempFile("oop-logger-test-", ".log");
        Files.deleteIfExists(tmp);

        Logger fileMinInfo = LoggerFactory.withMinLevel(LoggerFactory.file(tmp.toString()), LogLevel.INFO);
        fileMinInfo.log(LogLevel.INFO, "hello file");

        assertTrue(Files.exists(tmp));
        String content = Files.readString(tmp);
        assertTrue(content.contains("hello file"));

        Path tmp2 = Files.createTempFile("oop-logger-test-", ".log");
        Files.deleteIfExists(tmp2);

        Logger fileMinWarn = LoggerFactory.withMinLevel(LoggerFactory.file(tmp2.toString()), LogLevel.WARN);
        fileMinWarn.log(LogLevel.INFO, "should NOT be in file");
        fileMinWarn.log(LogLevel.ERROR, "should be in file");

        String content2 = Files.exists(tmp2) ? Files.readString(tmp2) : "";
        assertFalse(content2.contains("should NOT be in file"));
        assertTrue(content2.contains("should be in file"));
    }
}
