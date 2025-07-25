package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailManagerTest {

    private EmailManager emailManager;

    @BeforeEach
    void setup() {
        emailManager = new EmailManager();
    }

    @Test
    void testAddedEmailSuccess() {
        boolean added = emailManager.addEmail("test@something.com");
        assertTrue(added, "Email should be added successfully");
        assertTrue(emailManager.getEmails().contains("test@something.com"), "Email list should contain the added email");
    }

    @Test
    void testAddEmailDuplicate() {
        emailManager.addEmail("test@something.com");
        boolean addedAgain = emailManager.addEmail("test@something.com");
        assertFalse(addedAgain, "Duplicate email should not be added");
    }

    @Test
    void testUpdateEmailSuccess() {
        emailManager.addEmail("old@something.com");
        boolean updated = emailManager.updateEmail("old@something.com", "new@something.com");
        assertTrue(updated, "Email should be updated successfully");
        assertFalse(emailManager.getEmails().contains("old@something.com"), "Old email should be removed");
        assertTrue(emailManager.getEmails().contains("new@something.com"), "New email should be in list");
    }

    @Test
    void testDeleteEmailSuccess() {
        emailManager.addEmail("delete@something.com");
        boolean deleted = emailManager.deleteEmail("delete@something.com");
        assertTrue(deleted, "Email should be deleted successfully");
        assertFalse(emailManager.getEmails().contains("delete@something.com"), "Email list should not contain the deleted email");
    }

    @Test
    void testDeleteEmailNotFound() {
        boolean deleted = emailManager.deleteEmail("notfound@something.com");
        assertFalse(deleted, "Deleting a non-existing email should fail");
    }
}
