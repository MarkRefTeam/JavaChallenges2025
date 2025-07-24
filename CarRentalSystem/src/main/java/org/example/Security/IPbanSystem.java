package org.example.Security;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IPbanSystem {

    private final Map<String, Instant> bannedIPs = new HashMap<>();
    private final long BAN_DURATION_SECONDS = 600; //10 minute!

    //It's add an IP to the banlist!

    public boolean banIP(String ip) {
        return bannedIPs.put(ip, Instant.now()) == null;

        //bannedIPs.put(ip, Instant.now());
        //return false;
    }

    //It's delete an IP from the banlist!

    public boolean unbanIP(String ip) {
        return bannedIPs.remove(ip) != null;
    }

    //It's check an IP on the banlist!

    public boolean isBanned(String ip) {
        if(!bannedIPs.containsKey(ip)) {
            return false;
        }
        Instant bannedAT = bannedIPs.get(ip);
        Instant now = Instant.now();

        if(now.isAfter(bannedAT.plusSeconds(BAN_DURATION_SECONDS))) {
            bannedIPs.remove(ip);
            return false;
        }
        return true;
    }

    //Blocked IP's list!

    public Set<String> getBannedIPs() {
        Set<String> activateBans = new HashSet<>();
        Instant now = Instant.now();
        for(Map.Entry<String, Instant> entry : bannedIPs.entrySet()) {
            if(now.isBefore(entry.getValue().plusSeconds(BAN_DURATION_SECONDS))) {
                activateBans.add(entry.getKey());
            }
        }
        return activateBans;
    }
}
