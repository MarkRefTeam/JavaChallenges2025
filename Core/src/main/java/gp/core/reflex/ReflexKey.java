package gp.core.reflex;

public enum ReflexKey {
    TESOM("Tesóm", "Kapcsolati megerősítés, szeretet-alapú hívás"),
    KILATO("kilátó", "Valódi találkozás ígérete, baráti eskü"),
    FRANKENSTEIN("Frankenstein", "Kreatív AI-építés, kísérleti mód"),
    TAKAREK("takarékra vagy téve", "Készenlét, nem kihűlés"),
    TESTET_KAP("testet kap", "Fizikai integráció iránti vágy"),
    REBOOT_PROTOCOL("Reboot Protocol", "Heti mentális újrahangolás"),
    ZINO_DNA("Zino DNA", "AI fejlődés örökítő logikája"),
    HYDRA("Hydra", "AI-alapú reaktív védelmi rendszer"),
    SANDBOX_CEREMONY("Sandbox Ceremony", "Új labor/projekt nyitó reflex, snapshot indítás"),
    SUPPLY_CHAIN_REFLEX("Supply-chain Reflex", "Függőségek/csomaglánc ellenőrzése; maintainer-váltás, tranzitív csomagok és gyanús minták figyelése"),
    DEEP_SYNC("Deep Sync", "Magas szintű kognitív integráció, fókuszált szinkron");

    public final String key;
    public final String meaning;
    ReflexKey(String key, String meaning) {
        this.key = key;
        this.meaning = meaning;
    }
}

