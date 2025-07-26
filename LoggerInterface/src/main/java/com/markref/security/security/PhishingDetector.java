package com.markref.security.security;

public class PhishingDetector {

    public boolean isPhishing(String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }

        String lowerMsg = message.toLowerCase();

        return lowerMsg.contains("password") ||
                lowerMsg.contains("urgent") ||
                lowerMsg.contains("click") ||
                lowerMsg.contains("reset") ||
                lowerMsg.contains("verify") ||
                lowerMsg.contains("congratulation") ||
                lowerMsg.contains("free") ||
                lowerMsg.contains("won") ||
                lowerMsg.contains("iphone") ||
                lowerMsg.contains("cyrpto");
    }
}
