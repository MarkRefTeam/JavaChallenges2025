package gp.core.patch;

public interface GpPatch {
    default String id() {
        return "GP-2025-09-27";
    }
    String description();
    void apply();
}
