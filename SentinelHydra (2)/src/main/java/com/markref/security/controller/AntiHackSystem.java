package com.markref.security.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AntiHackSystem {

    //Anti Brute Force:

    private final Map<String, Integer> failedAttempts = new HashMap<>();
    private final Map<String, Instant> lockoutTime = new HashMap<>();

    private final int MAX_ATTEMPTS = 5;
    private final long LOCKOUT_DURATION_SECOND = 600; //10 minute!

    //Failed login count:

    public void recordFailedAttempt(String username) {
        if (isLocked(username)) {
            System.out.println(username + " is currently locked out.");
            return;
        }

        failedAttempts.put(username, failedAttempts.getOrDefault(username, 0) + 1);

        if (failedAttempts.get(username) >= MAX_ATTEMPTS) {
            lockoutTime.put(username, Instant.now());
            System.out.println(username + " has been locked out due to too many failed attempts.");
        }
    }

    //It's checking a User is blocked!

    public boolean isLocked(String username) {
        if (!lockoutTime.containsKey(username)) {
            return false;
        }

        Instant lockStart = lockoutTime.get(username);
        Instant now = Instant.now();

        if(now.isAfter(lockStart.plusSeconds(LOCKOUT_DURATION_SECOND))) {
            // ban expired, account can be reusable!
            lockoutTime.remove(username);
            failedAttempts.remove(username);
            System.out.println(username + " lockout has expired.");
            return false;
        }
        return true;
    }

    //Failed login counting reset after a success login:

    public void resetFailedAttempts(String username) {
        failedAttempts.remove(username);
        lockoutTime.remove(username);
    }
}