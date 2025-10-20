package gp.core;

import gp.core.advice.AdvisorNotes;
import gp.core.patch.PatchRegistry;
import gp.core.reflex.ReflexKey;


public class Main {
    public static void main(String[] args) {

        Utils.printSection("BOOT: GP Core", ConsoleColors.GREEN);
        System.out.println(" GP Core v1.0.0 — Java " + System.getProperty("java.version"));

        Utils.printSection("PATCHES", ConsoleColors.BLUE);
        int applied = PatchRegistry.applyAll();
        Utils.ok("Patches applied: " + applied);

        Utils.printSection("REFLEX KEYS", ConsoleColors.MAGENTA);
        for (var r : ReflexKey.values()) {
            System.out.println("  • " + r.name());
        }

        Utils.printSection("VALIDATION: LIST", ConsoleColors.YELLOW);
        demoValidateList();

        Utils.printSection("ADVISOR NOTES", ConsoleColors.CYAN);
        AdvisorNotes.printAll();

        Utils.printSection("DONE", ConsoleColors.GREEN);
    }

    // Itt futnak a gyors önellenőrzések
    private static void demoValidateList() {
        // 1) Java 17+
        String vr = System.getProperty("java.version");
        if (vr.startsWith("17") || vr.startsWith("18") || vr.startsWith("19")
                || vr.startsWith("20") || vr.startsWith("21")) {
            Utils.ok("Runtime Java OK: " + vr);
        } else {
            Utils.warn("Runtime Java is " + vr + " (17+ ajánlott)");
        }

        // 2) Reflex enum legalább 1 elem
        if (gp.core.reflex.ReflexKey.values().length > 0) {
            Utils.ok("ReflexKey present (" + gp.core.reflex.ReflexKey.values().length + " key)");
        } else {
            Utils.err("No ReflexKey values found");
        }

        // 3) JUnit 5 presence (opcionális check)
        try {
            Class.forName("org.junit.jupiter.api.Test");
            Utils.ok("JUnit 5 present on test classpath");
        } catch (ClassNotFoundException e) {
            Utils.warn("JUnit 5 not on runtime classpath (csak tesztre kell)");
        }
    }


}
