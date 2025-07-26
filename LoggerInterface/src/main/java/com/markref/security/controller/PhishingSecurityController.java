package com.markref.security.controller;

import com.markref.security.logging.Logger;
import com.markref.security.security.PhishingDetector;

public class PhishingSecurityController {

    private PhishingDetector detector;
    private Logger logger;

    public PhishingSecurityController(PhishingDetector detector, Logger logger) {
        this.detector = detector;
        this.logger = logger;
    }

    public void checkMessage(String message) {
        if(detector.isPhishing(message)) {
            logger.log("Phishing attempt detected: " + message);
        }
    }
}
