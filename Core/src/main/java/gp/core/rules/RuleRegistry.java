package gp.core.rules;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RuleRegistry {

    private RuleRegistry() {
    }

    private static final Map<RuleId, String> RULES = new LinkedHashMap<>();

    public static void upsertIfBlank(RuleId id, String desc) {
        RULES.merge(id, desc, (oldV, newV) -> {
            if (oldV == null || oldV.isBlank()) return newV;
            if (newV == null || newV.isBlank()) return oldV;
            return newV;
        });
    }

    public static void addIfAbsent(RuleId id, String desc) {
        RULES.putIfAbsent(id, desc);
    }

    public static String get(RuleId id) {
        return RULES.get(id);
    }


    public static Map<RuleId, String> snapshot() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(RULES));
    }

    public static void logAll() {
        System.out.println("──── GP RULES (" + RULES.size() + ") ────");
        RULES.forEach((id, desc) -> {
            String tail = (desc != null && !desc.isBlank()) ? " → " + desc : "";
            System.out.println("• " + id + tail);
        });
    }
}