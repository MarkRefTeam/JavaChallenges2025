package hu.mark.loggerdemo;

import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) {
        Logger console = new ConsoleLogger(true);
        Logger file = new FileLogger(Path.of("app.log"));

        console.log("Hello, Console!");
        file.log("Hello, File!");
        console.log("Check app.log in project root.");
    }
}
