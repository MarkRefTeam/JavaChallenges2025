package gp.core.advice;

import gp.core.ConsoleColors;
import gp.core.Utils;

public final class AdvisorNotes {
    private AdvisorNotes() {}

    public static void printAll() {
        Utils.printSection("SENTINELHYDRA: GP Advisor Notes", ConsoleColors.CYAN);
        System.out.println("✔ PhishingSimulator: random sablonok + log → ML előkészítés");
        System.out.println("✔ AntiHackSystem: lock események, webhook/e-mail opció");
        System.out.println("✔ HydraDefense: több threat level, sandbox/fagyasztás stratégia");
        System.out.println("✔ DependencyScanner: trusted repo + később Snyk API");
        System.out.println("✔ DataProtector: AES-GCM oké; később RSA hibrid, kulcstárolás");
        System.out.println("✔ Reflex: enum + registry (kész)");
        System.out.println("✔ Patch keret: naplózás, idempotencia, rollback hook (előkészíthető)");
        System.out.println("✔ TestSuite: moduláris regresszió/behavior");
        System.out.println("--------------------------------------------");
        System.out.println("Márk + GP = Szimbiotikus tanulás aktív állapotban.");
        System.out.println("Future Goal: AI-védelem mindig szem előtt.");
    }
}