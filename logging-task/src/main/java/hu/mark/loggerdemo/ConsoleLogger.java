package hu.mark.loggerdemo;

import java.time.Instant;

public final class ConsoleLogger implements Logger {
    private final boolean withTimestamp;

    public ConsoleLogger() {
        this(true); }
    public ConsoleLogger(boolean withTimestamp) { this.withTimestamp = withTimestamp; }

    @Override public void log(String message) {
        String msg = withTimestamp ? "[" + Instant.now() + "] " + message : message;
        System.out.println(msg);
    }
}
