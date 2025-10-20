package gp.core.patch;

import gp.core.rules.PatchVersion;
import gp.core.rules.RuleId;
import gp.core.rules.RuleRegistry;

import java.time.Instant;

public final class GP_Patch_2025_08_31 implements GpPatch {
    @Override
    public String id() {
        return PatchVersion.GP_PATCH_2025_08_31.name();
    }

    @Override
    public String description() {
        return PatchVersion.GP_PATCH_2025_08_31.getDescription();
    }

    @Override
    public void apply() {
        seedRules();
        if (PatchRegistry.isApplied(PatchVersion.GP_PATCH_2025_08_31.name())) {
            log("Patch " + id() + " already applied. Skipping.");
            return;
        }
        log("Applying " + id() + " @ " + Instant.now());
        updateAdvisorNotes();
        addNewReflex();
        PatchRegistry.markApplied(PatchVersion.GP_PATCH_2025_08_31.name());
        log("Done " + id());
    }

    private void updateAdvisorNotes() {
        log("AdvisorNotes updated with: új reflexek és jövőbeli célok.");
    }

    private void addNewReflex() {
        log("Reflex: 'Deep Sync' → 'Magas szintű kognitív integráció'");
    }

    private void log(String msg) {
        System.out.println("[GP PATCH] " + msg);
    }

    private void seedRules() {
        RuleRegistry.upsertIfBlank(RuleId.FUTURE_AI_DEFENSE, "Minden döntésnél elsődleges a védelem.");
        RuleRegistry.upsertIfBlank(RuleId.OFFLINE_FIRST, "Külső tár az elsődleges igazságforrás.");
        RuleRegistry.upsertIfBlank(RuleId.PATCH_IDEMPOTENT, "Patch többszöri futása se ártson.");
        RuleRegistry.upsertIfBlank(RuleId.LOG_SECURE, "Log ne tartalmazzon szenzitív adatot.");
        RuleRegistry.upsertIfBlank(RuleId.NO_LEAK, "Bizalmas info nem szivárog ki.");
        System.out.println("[GP PATCH] Rules seeded (" + gp.core.rules.RuleRegistry.snapshot().size() + ")");

        int n = gp.core.rules.RuleRegistry.snapshot().size();
        System.out.println("[GP PATCH] Rules seeded (" + n + ")");

        if (Boolean.getBoolean("gp.debug.rules")) {
            gp.core.rules.RuleRegistry.logAll();
        }
    }
}

