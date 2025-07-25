package org.example.cfsmalltasks;

import java.util.HashSet;
import java.util.Set;

public class Service {

    private Set<Email> emails = new HashSet<>();

    public boolean addEmail(Email email) {
        return emails.add(email);
    }

    public boolean removeEmail(String address) {
        return emails.removeIf(email -> email.getAddress().equals(address));
    }

    public boolean updateEmail(String oldAddress, Email newEmail) {
        if(removeEmail(oldAddress)) {
            return addEmail(newEmail);
        }
        return false;
    }

    public Set<Email> getEmails() {
        return new HashSet<>(emails);
    }
}