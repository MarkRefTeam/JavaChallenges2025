package org.example.cfsmalltasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void testEmailCreationAndGetters() {
        Email email = Email.builder()
                .address("test@example.com")
                .verified(true)
                .ownerName("Márk")
                .build();

        assertEquals("test@example.com", email.getAddress());
        assertTrue(email.isVerified());
        assertEquals("Márk", email.getOwnerName());
    }

    @Test
    void testSetters() {
        Email email = new Email();
        email.setAddress("hello@example.com");
        email.setVerified(false);
        email.setOwnerName("Anna");

        assertEquals("hello@example.com", email.getAddress());
        assertFalse(email.isVerified());
        assertEquals("Anna", email.getOwnerName());
    }
}