package logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(LogLevel level, String message) {
        log("[" + level + "] " + message);
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("File logging failed for path: " + filePath, e);
        }
    }
}
