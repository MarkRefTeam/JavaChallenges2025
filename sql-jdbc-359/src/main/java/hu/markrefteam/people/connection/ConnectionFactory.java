package hu.markrefteam.people.connection;

import hu.markrefteam.people.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {

    private ConnectionFactory() {
        // utility class – no instance allowed
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    DatabaseConfig.URL,
                    DatabaseConfig.USERNAME,
                    DatabaseConfig.PASSWORD
            );
        } catch (SQLException e) {
            throw new IllegalStateException(
                    "Failed to create database connection", e
            );
        }
    }
}

