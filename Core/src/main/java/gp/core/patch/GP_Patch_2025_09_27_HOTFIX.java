package gp.core.patch;

import gp.core.rules.RuleId;
import gp.core.rules.RuleRegistry;

public final class GP_Patch_2025_09_27_HOTFIX implements GpPatch {

    @Override
    public String id() {
        return "GP-2025-09-27-HOTFIX";
    }

    @Override
    public String description() {
        return "Supply-chain szabály leírás upsert + kapcsolódó leírások fix";
    }

    @Override
    public void apply() {
        upsert(RuleId.SUPPLY_CHAIN_REFLEX_RULE,
                "Függőségfigyelés: maintainer-csere, új tranzitív csomag, gyanús kódminták. Bizalom előtt: riasztás + sandbox.");

        upsert(RuleId.RECOVERY_PROTOCOL,
                "Napi 2–3 órás tanulási keret, heti 1 mini-maraton; cél: gyors visszaállás és szintlépés.");
        upsert(RuleId.SAFETY_SNAPSHOT_RULE,
                "Minden érdemi változtatás előtt/után snapshot készül; visszaállítási pontok kötelezőek.");
        upsert(RuleId.SANDBOX_OPENING_RULE,
                "SANDBOX_CEREMONY: új labor/projekt nyitásakor nyitó snapshot + kontrollált indítás.");

        System.out.println("[GP HOTFIX] " + id() + " :: supply-chain és társak leírásai frissítve.");
        PatchRegistry.markApplied(id());
    }

    private void upsert(RuleId id, String desc) {
        RuleRegistry.upsertIfBlank(id, desc);
        String v = RuleRegistry.get(id);
        System.out.println(" - " + id + " → " + (v == null ? "<null>" : v));
    }
}

