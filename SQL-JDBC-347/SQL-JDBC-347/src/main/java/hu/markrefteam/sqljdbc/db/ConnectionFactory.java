package hu.markrefteam.sqljdbc.db;

import hu.markrefteam.sqljdbc.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DatabaseConfig.url(),
                DatabaseConfig.username(),
                DatabaseConfig.password()
        );
    }
}
