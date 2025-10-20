package hu.mark.loggerdemo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

public final class FileLogger implements Logger {
    private final Path file;
    private final Charset charset;
    private final boolean withTimestamp;
    private final Set<StandardOpenOption> options;

    public FileLogger(Path file) {
        this(file, Charset.forName("UTF-8"), true, true);
    }

    public FileLogger(Path file, Charset charset, boolean append, boolean withTimestamp) {
        this.file = file;
        this.charset = charset;
        this.withTimestamp = withTimestamp;
        this.options = append
                ? EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.APPEND)
                : EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
    }

    @Override public void log(String message) {
        String line = (withTimestamp ? "[" + Instant.now() + "] " : "") + message + System.lineSeparator();
        try {
            Files.writeString(file, line, charset, options.toArray(StandardOpenOption[]::new));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write log to " + file, e);
        }
    }
}
