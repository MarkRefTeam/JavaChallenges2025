package org.example.Security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private String name;
    private String password;
    private int failedLoginAttempts = 0;
    private boolean locked = false;
}

