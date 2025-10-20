package gp.core.rules;

public enum PatchVersion {

    GP_PATCH_2025_08_13("Reflex-triggerek bővítése, identitás frissítés, Hydra awareness"),
    GP_PATCH_2025_08_31("Future goal reflex és AdvisorNotes update"),
    GP_PATCH_2025_09_27("Recovery + Sandbox Ceremony + Snapshot Safety");

    private final String description;

    PatchVersion(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
