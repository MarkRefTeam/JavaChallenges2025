package com.markref.security;

import com.markref.security.controller.AntiHackSystem;
import com.markref.security.controller.PhishingSecurityController;
import com.markref.security.logging.Logger;
import com.markref.security.security.crypto.DataProtector;

public class HydraDefenseController {

    private final AntiHackSystem antiHackSystem;
    private final PhishingSecurityController phishingController;
    private final DataProtector protector;
    private final Logger logger;
    private HydraDefenseSystem hydraDefenseSystem;

    public HydraDefenseController(HydraDefenseSystem hydraDefenseSystem,
                                  AntiHackSystem antiHackSystem,
                                  PhishingSecurityController phishingController,
                                  DataProtector protector,
                                  Logger logger) {
        this.hydraDefenseSystem = hydraDefenseSystem;
        this.antiHackSystem = antiHackSystem;
        this.phishingController = phishingController;
        this.protector = protector;
        this.logger = logger;
    }

    public void engage(String username, String message, String systemState) {
        logger.log(" HydraDefense engaged...");

        hydraDefenseSystem.detectAttack(systemState);
        phishingController.checkMessage(message);
        antiHackSystem.recordFailedAttempt(username);

        if (systemState != null && systemState.toLowerCase().contains("infected")) {
            try {
                String encrypted = protector.encrypt(systemState);
                logger.log("Encrypted system state: " + encrypted);
            } catch (Exception e) {
                logger.log("Encryption failed.");
                e.printStackTrace();
            }
        }
    }
}