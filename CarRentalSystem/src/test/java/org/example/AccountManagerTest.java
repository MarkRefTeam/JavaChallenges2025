package org.example;

import org.example.Security.AccountManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountManagerTest {

    private AccountManager manager;

    @BeforeEach
    public void setup() {
        manager = new AccountManager();
    }

    @Test
    public void testCreateAccountSuccess() {

        boolean created = manager.createAccount("user1","pass123",0,false);
        assertTrue(created);
    }

    @Test
    public void testCreateAccountDuplicate() {
        manager.createAccount("user1", "pass123", 0, false);
        boolean createdAgain = manager.createAccount("user1", "otherPass", 0, false);
        assertFalse(createdAgain);
    }

    @Test
    public void testAuthenticateSuccess() {
        manager.createAccount("user2", "mypassword", 0, false);
        boolean result = manager.authenticate("user2", "mypassword");
        assertTrue(result);
    }

    @Test
    public void testAuthenticateFailWrongPassword() {
        manager.createAccount("user3", "1234", 0, false);
        boolean result = manager.authenticate("user3", "wrongpass");
        assertFalse(result);
    }

    @Test
    public void testAuthenticateLockAfterThreeFails() {
        manager.createAccount("user4", "secret", 0, false);
        manager.authenticate("user4", "bad1");
        manager.authenticate("user4", "bad2");
        boolean thirdTry = manager.authenticate("user4", "bad3");
        assertFalse(thirdTry);

        // Attempt after lock
        boolean lockedTry = manager.authenticate("user4", "secret");
        assertFalse(lockedTry);
    }

    @Test
    public void testDeleteAccountSuccess() {
        manager.createAccount("user5", "deleteMe", 0, false);
        boolean deleted = manager.deleteAccount("user5");
        assertTrue(deleted);
    }

    @Test
    public void testDeleteAccountNotFound() {
        boolean deleted = manager.deleteAccount("ghostUser");
        assertFalse(deleted);
    }

    @Test
    public void testChangePasswordSuccess() {
        manager.createAccount("user6", "oldpass", 0, false);
        boolean changed = manager.changePassword("user6", "oldpass", "newpass");
        assertTrue(changed);

        // Should be able to log in with new pass
        assertTrue(manager.authenticate("user6", "newpass"));
    }

    @Test
    public void testChangePasswordFailWrongOld() {
        manager.createAccount("user7", "initial", 0, false);
        boolean changed = manager.changePassword("user7", "wrongOld", "newpass");
        assertFalse(changed);
    }
}