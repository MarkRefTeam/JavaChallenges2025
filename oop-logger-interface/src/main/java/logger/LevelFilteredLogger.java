package logger;

public class LevelFilteredLogger implements Logger {
    private final Logger base;
    private final LogLevel minLevel;

    public LevelFilteredLogger(Logger base, LogLevel minLevel) {
        this.base = base;
        this.minLevel = minLevel;
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= minLevel.ordinal()) {
            base.log(level, message);
        }
    }
}
