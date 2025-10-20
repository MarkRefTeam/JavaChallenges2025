package com.markref.security.controller;


import com.markref.security.logging.Logger;
import com.markref.security.security.PhishingDetector;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PhishingSecurityControllerTest {

    @Test
    void testCheckMessageLogsPhishing() {
        Logger mockLogger = mock(Logger.class);
        PhishingDetector detector = new PhishingDetector();
        PhishingSecurityController controller = new PhishingSecurityController(detector, mockLogger);

        String phishingMessage = "Urgent! Reset your password now!";
        controller.checkMessage(phishingMessage);

        verify(mockLogger).log(contains("Phishing attempt detected"));
    }

    @Test
    void testCheckMessageDoesNotLogNonPhishing() {
        Logger mockLogger = mock(Logger.class);
        PhishingDetector detector = new PhishingDetector();
        PhishingSecurityController controller = new PhishingSecurityController(detector, mockLogger);

        String cleanMessage = "Hello, how are you?";
        controller.checkMessage(cleanMessage);

        verify(mockLogger, never()).log(anyString());
    }
}