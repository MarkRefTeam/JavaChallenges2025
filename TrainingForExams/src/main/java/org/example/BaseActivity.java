package org.example;

public abstract class BaseActivity implements Activity {
    private final int durationMinutes;
    private final ActivityType type;

    public BaseActivity(int durationMinutes, ActivityType type) {
        this.durationMinutes = durationMinutes;
        this.type = type;
    }

    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ActivityType getType() {
        return type;
    }
}

