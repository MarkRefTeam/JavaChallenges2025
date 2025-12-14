package logger;

import java.util.ArrayList;
import java.util.List;

public class SpyLogger implements Logger {
    private final List<String> entries = new ArrayList<>();

    @Override
    public void log(LogLevel level, String message) {
        entries.add("[" + level + "] " + message);
    }

    public List<String> entries() {
        return entries;
    }
}