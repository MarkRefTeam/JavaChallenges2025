package org.example;

import lombok.var;
import org.example.Security.IPbanSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class IPbanSystemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private IPbanSystem ipbanSystem;

    @BeforeEach
    public void setUP() {
        System.setOut(new PrintStream(outContent));
        ipbanSystem = new IPbanSystem();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testBanIP() {
        String testIP = "192.168.1.100";

        boolean banned = ipbanSystem.banIP(testIP);
        assertTrue(banned, "The IP should be banned successfully");

        boolean isBanned = ipbanSystem.isBanned(testIP);
        assertTrue(isBanned, "The IP should be listed as banned");
        assertTrue(ipbanSystem.getBannedIPs().contains(testIP), "Banned IP list should contain the IP");
    }

    @Test
    public void testBanIP_AddsIPToBanList() {
        boolean banned = ipbanSystem.banIP("192.168.1.100");
        assertTrue(banned, "IP should be added to ban list");
        assertTrue(ipbanSystem.isBanned("192.168.1.100"), "IP should be recognized as banned");
    }

    @Test
    public void testBanIP_ReturnsFalseIfAlreadyBanned() {
        ipbanSystem.banIP("192.168.1.101");
        boolean bannedAgain = ipbanSystem.banIP("192.168.1.101");
        assertFalse(bannedAgain, "Banning an already banned IP should return false");
    }

    @Test
    public void testUrbanIP_ReturnFalseIfNotBanned() {
        boolean unbanned = ipbanSystem.unbanIP("192.168.1.103");
        assertFalse(unbanned, "Unbanning an IP in the ban list should return false");
    }

    @Test
    public void testIsBanned_ReturnsFalseForNonBannedIP() {
        assertFalse(ipbanSystem.isBanned("192.168.1.104"), "IP not banned should return false");
    }

    @Test
    public void testGetBannedIPs_ReturnsAllCurrentlyBannedIPs() {
        ipbanSystem.banIP("192.168.1.105");
        ipbanSystem.banIP("192.168.1.106");

        var bannedIPs = ipbanSystem.getBannedIPs();
        assertTrue(bannedIPs.contains("192.168.1.105"));
        assertTrue(bannedIPs.contains("192.168.1.106"));
        assertEquals(2, bannedIPs.size());
    }
}
