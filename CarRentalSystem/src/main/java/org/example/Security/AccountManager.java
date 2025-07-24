package org.example.Security;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    //Okay Let's practice Algorithmic!

    private Map<String, Account> accounts = new HashMap<>();

    public boolean createAccount(String username, String password, int failedLoginAttempts, boolean locked) {
        if (accounts.containsKey(username)) {
            return false;
        }
        accounts.put(username, Account.builder()
                .name(username)
                .password(password)
                .failedLoginAttempts(0)
                .locked(false)
                .build());
        return true;
    }

    public boolean authenticate(String username, String password) {
        Account account = accounts.get(username);
        if (account == null) {
            return false;
        }

        if(account.isLocked()) {
            System.out.println("Account is locked due to multiple failed login attempts. ");
            return false;
        }

        if(account.getPassword().equals(password)) {
            account.setFailedLoginAttempts(0);
            return true;
        } else {
            account.setFailedLoginAttempts(account.getFailedLoginAttempts() + 1);
            if(account.getFailedLoginAttempts() >= 3) {
                account.setLocked(true);
                System.out.println("Account locked due to multiple failed login attempts. ");
            }
            return false;
        }
    }

    //Extra function's  here:

    public boolean deleteAccount(String username) {
        if(accounts.containsKey(username)) {
            accounts.remove(username);
                return true;
            }
        return false;
    }

    //Authentication and refresh password!

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        Account account = accounts.get(username);
        if(account != null && account.getPassword().equals(oldPassword)) {
            account.setPassword(newPassword);
            return true;
        }
        return false;
    }
}