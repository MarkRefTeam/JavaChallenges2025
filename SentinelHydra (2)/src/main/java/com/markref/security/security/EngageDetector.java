package com.markref.security.security;

public class EngageDetector {

    public boolean detectEngage(String systemState) {
        return systemState !=null && systemState.toLowerCase().contains("infected");
    }
}