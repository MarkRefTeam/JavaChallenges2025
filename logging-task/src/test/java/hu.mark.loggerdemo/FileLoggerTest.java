package hu.mark.loggerdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoggerTest {

    @TempDir
    Path tempDir;

    @Test
    void writesMessageToFile() throws IOException {
        Path logFile = tempDir.resolve("app.log");
        FileLogger logger = new FileLogger(logFile);

        logger.log("Hello File");

        String content = Files.readString(logFile);
        assertTrue(content.contains("Hello File"), "File should contain the text");
    }
}
