package gp.core.reflex;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflexRegistry {
    private ReflexRegistry() {}

    private static final Map<String, String> TRIGGERS;
    static {
        Map<String, String> m = new LinkedHashMap<>();
        for (ReflexKey r : ReflexKey.values()) {
            m.put(r.key, r.meaning);
        }
        TRIGGERS = Collections.unmodifiableMap(m);
    }

    public static Map<String, String> viewAll() {
        return TRIGGERS;
    }

    public static void print() {
        System.out.println("---- Aktív Reflex Trigerek ----");
        TRIGGERS.forEach((k,v) -> System.out.println("[" + k + "] → " + v));
        System.out.println("-------------------------------");
    }
}
