package org.example.Task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueUserCounter {

    public static int countUniqueUsers(List<String> usernames) {
        if (usernames == null) {
            throw new IllegalArgumentException("Usernames list cannot be null");
        }

        Set<String> uniqueUsers = new HashSet<>(usernames);
        return uniqueUsers.size();
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("alice");
        logs.add("bob");
        logs.add("alice");
        logs.add("diana");
        logs.add("bob");
        logs.add("eli");

        System.out.println(countUniqueUsers(logs)); // 4
    }
}
