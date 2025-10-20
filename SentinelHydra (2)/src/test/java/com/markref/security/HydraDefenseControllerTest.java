package com.markref.security;

import com.markref.security.controller.AntiHackSystem;
import com.markref.security.controller.PhishingSecurityController;
import com.markref.security.logging.Logger;
import com.markref.security.security.crypto.DataProtector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HydraDefenseControllerTest {

    private HydraDefenseController hydraDefenseController;

    //Mock:
    private AntiHackSystem antiHackSystem;
    private PhishingSecurityController phishingSecurityController;
    private DataProtector protector;
    private Logger logger;

    @BeforeEach
    void setup() {
        antiHackSystem = mock(AntiHackSystem.class);
        phishingSecurityController = mock(PhishingSecurityController.class);
        protector = mock(DataProtector.class);
        logger = mock(Logger.class);
        HydraDefenseSystem hydraDefenseSystem = mock(HydraDefenseSystem.class);

        hydraDefenseController = new HydraDefenseController(
                hydraDefenseSystem,
                antiHackSystem,
        phishingSecurityController,
        protector,
        logger
        );
    }

    @Test
    void testEngageCallsComponents() throws Exception {
        String username = "mark";
        String message = "Phishing attempts!";
        String systemState = "infected";

        when(protector.encrypt(systemState)).thenReturn("encryptedData");

        hydraDefenseController.engage(username,message,systemState);

        verify(phishingSecurityController).checkMessage(message);
        verify(antiHackSystem).recordFailedAttempt(username);
        verify(protector).encrypt(systemState);
        verify(logger).log(contains("HydraDefense engaged"));
        verify(logger).log(contains("Encrypted system state"));
    }
}