package com.markref.security.security;

public class SecurityController {

    private EngageDetector detector = new EngageDetector();
    private Isolator isolator = new Isolator();

    public void monitor(String systemState) {
        if(detector.detectEngage(systemState)) {
            isolator.isolate(systemState);
        }
    }
}