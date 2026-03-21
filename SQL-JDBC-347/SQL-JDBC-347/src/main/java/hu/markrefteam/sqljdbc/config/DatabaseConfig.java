package hu.markrefteam.sqljdbc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DatabaseConfig {

    private static final String PROPS_FILE = "/db.properties";
    private static final String KEY_URL = "db.url";
    private static final String KEY_USER = "db.username";
    private static final String KEY_PASS = "db.password";

    private static final Properties PROPS = load();

    private DatabaseConfig() {}

    public static String url() {
        return PROPS.getProperty(KEY_URL);
    }

    public static String username() {
        return PROPS.getProperty(KEY_USER);
    }

    public static String password() {
        return PROPS.getProperty(KEY_PASS);
    }

    private static Properties load() {
        try (InputStream is = DatabaseConfig.class.getResourceAsStream(PROPS_FILE)) {
            if (is == null) {
                throw new IllegalStateException("Missing " + PROPS_FILE + " in resources (and/or not found on classpath).");
            }
            Properties p = new Properties();
            p.load(is);

            requireNonBlank(p, KEY_URL);
            requireNonBlank(p, KEY_USER);
            requireNonBlank(p, KEY_PASS);

            return p;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + PROPS_FILE, e);
        }
    }

    private static void requireNonBlank(Properties p, String key) {
        String v = p.getProperty(key);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException("Missing/blank property: " + key);
        }
    }
}
