package gp.core.patch;

import gp.core.rules.PatchVersion;
import gp.core.rules.RuleId;
import gp.core.rules.RuleRegistry;

public final class GP_Patch_2025_09_27 implements GpPatch {

    @Override
    public String id() {
        return "GP-2025-09-27";
    }

    @Override
    public String description() {
        return "Recovery Protocol + Sandbox Ceremony + Snapshot Safety bevezetése";
    }

    @Override
    public void apply() {

        RuleRegistry.upsertIfBlank(
                RuleId.RECOVERY_PROTOCOL,
                "Napi 2–3 órás tanulási keret: Blokk1=Tananyag, Blokk2=Security/Sandbox, Blokk3=Review; " +
                        "heti 1 mini-maraton (4–5 óra); cél: 2 hét alatt visszaállás, 3 hét alatt szintlépés."
        );
        log("Rule: RECOVERY_PROTOCOL beállítva.");

        RuleRegistry.upsertIfBlank(
                RuleId.SAFETY_SNAPSHOT_RULE,
                "Minden új környezet (Kali/Hydra/Sandbox) mindig snapshotból indul; " +
                        "minden jelentős változás után új snapshot készül. Adatvesztés minimalizálása."
        );
        log("Rule: SAFETY_SNAPSHOT_RULE beállítva.");

        RuleRegistry.upsertIfBlank(
                RuleId.SANDBOX_OPENING_RULE,
                "SANDBOX_CEREMONY: új labor/projekt nyitásakor ünnepélyes start + snapshot; " +
                        "nyitóbeszéd opcionális; a run mindig kontrollált környezetben történik."
        );
        log("Rule: SANDBOX_OPENING_RULE beállítva.");

        RuleRegistry.upsertIfBlank(
                RuleId.SUPPLY_CHAIN_REFLEX_RULE,
                "Függőségfigyelés: maintainer-csere, új tranzitív csomag, gyanús kódminták. Bizalom előtt: riasztás + sandbox."
        );

        PatchRegistry.markApplied(PatchVersion.GP_PATCH_2025_09_27.name());
        log("Done " + id());
    }

    private void log(String msg) {
        System.out.println("[GP PATCH] " + id() + " :: " + msg);
    }
}
