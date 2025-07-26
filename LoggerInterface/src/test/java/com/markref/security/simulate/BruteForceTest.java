package com.markref.security.simulate;

import com.markref.security.controller.AntiHackSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BruteForceTest {

    @Test
    void testBruteForceLockout() {
        AntiHackSystem antiHack = new AntiHackSystem();
        BruteForceSimulator simulator = new BruteForceSimulator(antiHack);

        String username = "testUser";

        simulator.simulateAttack(username , 7);
        assertTrue(antiHack.isLocked(username), "The user must be locked out!");
    }
}
