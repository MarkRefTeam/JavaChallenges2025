package logger;

public interface Logger {
    void log(LogLevel level, String message);

    default void log(String message) {
        log(LogLevel.INFO, message);
    }
}
