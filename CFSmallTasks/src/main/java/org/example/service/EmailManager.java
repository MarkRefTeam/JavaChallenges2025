package org.example.service;

import java.util.HashSet;
import java.util.Set;

public class EmailManager {

    private Set<String> emails = new HashSet<>();

    public boolean addEmail(String email) {
        return emails.add(email);
    }

    public Set<String> getEmails() {
        return new HashSet<>(emails);
    }

    public boolean updateEmail(String oldEmail, String newEmail) {
        if(emails.contains(oldEmail) && !emails.contains(newEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
            return true;
        }
        return false;
    }

    public boolean deleteEmail(String email) {
        return emails.remove(email);
    }
}
