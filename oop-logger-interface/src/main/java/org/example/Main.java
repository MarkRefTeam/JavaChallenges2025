package org.example;

import logger.LogLevel;
import logger.Logger;
import logger.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger c = LoggerFactory.withMinLevel(LoggerFactory.console(), LogLevel.WARN);
        Logger f = LoggerFactory.withMinLevel(LoggerFactory.file("app.log"), LogLevel.INFO);

        c.log(LogLevel.INFO, "this not going to the console");
        c.log(LogLevel.ERROR, "This going out to the console");
        f.log(LogLevel.INFO, "that's going to the file");
    }
}
