package org.example;

import logger.LogLevel;
import logger.Logger;
import logger.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldWriteToFile() throws Exception {
        Path file = tempDir.resolve("app.log");
        Logger logger = LoggerFactory.file(file.toString());

        logger.log(LogLevel.INFO, "hello file");

        String content = Files.readString(file);
        assertTrue(content.contains("[INFO] hello file"));
    }
}
