package org.example.cfsmalltasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
    private String address;
    private boolean verified;
    private String ownerName;
}
