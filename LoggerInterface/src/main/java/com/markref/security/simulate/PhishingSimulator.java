package com.markref.security.simulate;

import com.markref.security.controller.PhishingSecurityController;

public class PhishingSimulator {

    private PhishingSecurityController controller;

    public PhishingSimulator(PhishingSecurityController controller) {
        this.controller = controller;
    }

    public void simulateMessage(String message) {
        controller.checkMessage(message);
    }

    public void simulatePhishing() {
        String phishingMessage = generatePhishingMessage();
        controller.checkMessage(phishingMessage);
    }

    public void simulateLegitimate() {
        String legitMessage = generateLegitimateMessage();
        controller.checkMessage(legitMessage);
    }

    public String generatePhishingMessage() {
        return "Urgent! Please reset your password immediately by clinking this link!";
    }

    public String generateLegitimateMessage() {

        return "Hello , just checking in to see how you're doing.";
    }
}
