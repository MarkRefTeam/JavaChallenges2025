package hu.markrefteam.people.config;

public final class DatabaseConfig {

    private DatabaseConfig() {
        // utility class – no instance allowed
    }

    public static final String DRIVER_CLASS_NAME =
            "com.mysql.cj.jdbc.Driver";

    public static final String URL =
            "jdbc:mysql://localhost:3306/people";

    public static final String USERNAME =
            "app";

    public static final String PASSWORD =
            "app123";
}
