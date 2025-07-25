package org.example;

import org.example.cfsmalltasks.Email;
import org.example.cfsmalltasks.Service;

public class Main {

    public static void main(String[] args) {
       Service service = new Service();

        Email email1 = Email.builder().address("mark@example.com").ownerName("Márk").verified(true).build();
        Email email2 = Email.builder().address("anna@example.com").ownerName("Anna").verified(false).build();

        service.addEmail(email1);
        service.addEmail(email2);

        System.out.println("Emails in system:");
        service.getEmails().forEach(email -> System.out.println(email.getAddress()));

        System.out.println("\nAdding duplicate email mark@example.com");
        boolean added = service.addEmail(email1);
        System.out.println("Was duplicate added? " + added);

        System.out.println("\nUpdating anna@example.com to anna2025@example.com");
        service.updateEmail("anna@example.com", Email.builder().address("anna2025@example.com").ownerName("Anna").verified(true).build());

        System.out.println("\nRemoving mark@example.com");
        service.removeEmail("mark@example.com");

        System.out.println("\nEmails after updates:");
        service.getEmails().forEach(email -> System.out.println(email.getAddress()));
    }
}
