package gp.core.patch;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class PatchRegistry {

    private static final Set<String> APPLIED = new LinkedHashSet<>();

    private static final List<GpPatch> PATCHES = List.of(
            new GP_Patch_2025_08_13(),
            new GP_Patch_2025_08_31(),
            new GP_Patch_2025_09_27(),
            new GP_Patch_2025_09_27_HOTFIX()
    );

    private PatchRegistry() {}

    public static boolean isApplied(String id) {
        return APPLIED.contains(id);
    }

    public static void markApplied(String id) {
        APPLIED.add(id);
    }

    public static int applyAll() {
        System.out.println(" PATCHES  @ " + java.time.Instant.now());
        System.out.println("────────────────────────────────────────────────────────────");
        int before = APPLIED.size();
        for (GpPatch p : PATCHES) {
            try {
                p.apply();
            } catch (Exception e) {
                System.out.println("[GP PATCH] ERROR in " + p.id() + ": " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        int appliedNow = APPLIED.size() - before;
        System.out.println("  ✅  Patches applied: " + appliedNow);
        return appliedNow;
    }
}
