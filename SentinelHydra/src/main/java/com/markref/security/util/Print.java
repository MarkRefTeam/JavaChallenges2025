package com.markref.security.util;

import java.time.LocalTime;

public final class Print {
    private Print() {}

    public static void section(String title, String color) {
        System.out.println(color + "\n[" + LocalTime.now() + "] --- " + title + " ---" + ConsoleColors.RESET);
    }
    public static void section(String title){ section(title, ConsoleColors.WHITE); }
}
