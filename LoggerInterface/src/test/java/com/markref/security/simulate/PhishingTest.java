package com.markref.security.simulate;

import com.markref.security.controller.PhishingSecurityController;
import com.markref.security.logging.Logger;
import com.markref.security.security.PhishingDetector;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

public class PhishingTest {

    @Test
    void testPhishingDetectionAndLogging() {
        Logger mockLogger = mock(Logger.class);

        PhishingDetector detector = new PhishingDetector();
        PhishingSecurityController controller = new PhishingSecurityController(detector, mockLogger);

        PhishingSimulator simulator = new PhishingSimulator(controller);

        String phishingMessage = "Urgent! Please reset your password immediately!";
        String normalMessage = "Hello, this is a normal message.";

        simulator.simulateMessage(phishingMessage);
        verify(mockLogger).log(contains("Phishing attempt detected"));

        clearInvocations(mockLogger); //reset Mockito!

        simulator.simulateMessage(normalMessage);
        verify(mockLogger, never()).log(contains("Phishing attempt detected"));
    }
}
