package com.markref.security.simulate;

import com.markref.security.controller.AntiHackSystem;

public class BruteForceSimulator {

    private AntiHackSystem antiHackSystem;

    public BruteForceSimulator(AntiHackSystem antiHackSystem) {
        this.antiHackSystem = antiHackSystem;
    }

    public void simulateAttack(String username, int attempts) {
        for (int i = 1; i < attempts; i++) {
            System.out.println("Attempts #" + i + " for user: " + username);
            antiHackSystem.recordFailedAttempt(username);
            if(antiHackSystem.isLocked(username)) {
                System.out.println(username + " is locked out. Stopping attack.");
                break;
            }
        }
    }
}
