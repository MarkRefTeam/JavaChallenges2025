package org.example;

public enum ActivityType {
    RUNNING("Running"),
    CYCLING("Cycling"),
    HIKING("Hiking");

    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}