package gp.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Utils {
    private static final String SEP = "─".repeat(60);

    public static void printSection(String title, String color) {
        String line = SEP;
        System.out.println(ConsoleColors.wrap(line, color));
        System.out.println(ConsoleColors.wrap(" " + title, color) + "  "
                + ConsoleColors.wrap("@ " + now(), ConsoleColors.CYAN));
        System.out.println(ConsoleColors.wrap(line, color));
    }

    public static void ok(String msg)   { System.out.println("  ✅  " + msg); }
    public static void warn(String msg) { System.out.println("  ⚠️  " + ConsoleColors.wrap(msg, ConsoleColors.YELLOW)); }
    public static void err(String msg)  { System.out.println("  ❌  " + ConsoleColors.wrap(msg, ConsoleColors.RED)); }

    private static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private Utils() {}
}
