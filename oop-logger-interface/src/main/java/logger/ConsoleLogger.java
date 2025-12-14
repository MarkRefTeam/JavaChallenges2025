package logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(LogLevel level, String message) {
        System.out.println("[" + level + "] " + message);
    }
}
