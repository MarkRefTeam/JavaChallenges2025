package logger;

public final class LoggerFactory {
    private LoggerFactory() {}

    public static Logger console() {
        return new ConsoleLogger();
    }

    public static Logger file(String filePath) {
        return new FileLogger(filePath);
    }

    public static Logger withMinLevel(Logger base, LogLevel minLevel) {
        return new LevelFilteredLogger(base, minLevel);
    }
}
