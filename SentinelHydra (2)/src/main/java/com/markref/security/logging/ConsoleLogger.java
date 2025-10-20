package com.markref.security.logging;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String massage) {
        System.out.println(massage);
    }
}