package org.example.cfsmalltasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private Service service;

    @BeforeEach
    void setup() {
        service = new Service();
    }

    @Test
    void testAddEmail() {
        Email email = Email.builder()
                .address("test@example.com")
                .verified(true)
                .ownerName("Márk")
                .build();

        assertTrue(service.addEmail(email));
        assertFalse(service.addEmail(email));
    }

    @Test
    void testRemoveEmail() {
        Email email = Email.builder()
                .address("remove@example.com")
                .build();

        service.addEmail(email);
        assertTrue(service.removeEmail("remove@example.com"));
        assertFalse(service.removeEmail("remove@example.com"));
    }

    @Test
    void testUpdateEmail() {
        Email oldEmail = Email.builder()
                .address("old@example.com")
                .build();
        Email newEmail = Email.builder()
                .address("new@example.com")
                .build();

        service.addEmail(oldEmail);
        assertTrue(service.updateEmail("old@example.com", newEmail));
        assertFalse(service.updateEmail("nonexistent@example.com", newEmail));
    }

    @Test
    void testGetEmails() {
        Email email1 = Email.builder().address("a@example.com").build();
        Email email2 = Email.builder().address("b@example.com").build();

        service.addEmail(email1);
        service.addEmail(email2);

        assertEquals(2, service.getEmails().size());
        assertTrue(service.getEmails().contains(email1));
        assertTrue(service.getEmails().contains(email2));
    }
}